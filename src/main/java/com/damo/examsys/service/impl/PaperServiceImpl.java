package com.damo.examsys.service.impl;

import com.damo.examsys.dao.PaperDao;
import com.damo.examsys.dao.QuestionsDao;
import com.damo.examsys.entity.Paper;
import com.damo.examsys.entity.Questions;
import com.damo.examsys.entity.QuestionsInfo;
import com.damo.examsys.service.PaperService;
import com.damo.examsys.service.QuestionsService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author liujiulong
 * @date 2019/10/17  11:58:00
 */
@Service
public class PaperServiceImpl implements PaperService {

    @Autowired
    private PaperDao paperDao;

    @Autowired
    private QuestionsDao questionsDao;

    @Autowired
    private QuestionsService questionsService;

    @Override
    public List<Paper> findAll(Map<String, Integer> pageMap, String paperName, Integer subjectId) {
        PageHelper.startPage(pageMap.get("page"), pageMap.get("limit"));
        return paperDao.findAll(paperName, subjectId);
    }

    @Override
    public void add(Paper paper) {
        List<Questions> choiceQuestionsList = questionsService.findByTypeIdAndSubjectId(1, paper.getSubjectId(), paper.getChoiceNum());
        List<Questions> completionQuestionsList = questionsService.findByTypeIdAndSubjectId(2, paper.getSubjectId(), paper.getCompletionNum());
        List<Questions> shortAnswerQuestionsList = questionsService.findByTypeIdAndSubjectId(3, paper.getSubjectId(), paper.getShortAnswerNum());

        String questionIds = getQuestionIdsStr(choiceQuestionsList) + getQuestionIdsStr(completionQuestionsList) + getQuestionIdsStr(shortAnswerQuestionsList);
       if (questionIds.equals("")){
           throw new RuntimeException("该科目题库为空");
       }
        String subString = questionIds.substring(1);

        paper.setQuestionIds(subString);
        paperDao.add(paper);

    }

    @Override
    public Paper findById(Integer paperId) {
        if (paperId == null){
            throw new RuntimeException("获取试卷信息错误");
        }
        return paperDao.findById(paperId);
    }

    @Override
    public void update(Paper paper) {
        paperDao.update(paper);
    }

    @Override
    public void deleteById(Integer paperId) {
        paperDao.deleteById(paperId);
    }

    @Override
    public QuestionsInfo getQuestions(Integer paperId) {
        Paper paper = paperDao.findById(paperId);
        String questionIds1 = paper.getQuestionIds();
        if (questionIds1.equals("")){
            throw new RuntimeException("该试卷题目为空");
        }
        String[] questionIds = questionIds1.split(",");

        ArrayList<Questions> choiceQuestions = new ArrayList<>();
        ArrayList<Questions> completionQuestions = new ArrayList<>();
        ArrayList<Questions> shortAnswerQuestions = new ArrayList<>();

        for (String questionId : questionIds) {
            Questions questions = questionsDao.findById(Integer.valueOf(questionId));
            if (1 == (questions.getTypeId())){
                choiceQuestions.add(questions);
            }else if (2 == (questions.getTypeId())){
                completionQuestions.add(questions);
            }else{
                shortAnswerQuestions.add(questions);
            }
        }

        QuestionsInfo questionsInfo = new QuestionsInfo();
        questionsInfo.setChoiceQuestions(choiceQuestions);
        questionsInfo.setCompletionQuestions(completionQuestions);
        questionsInfo.setShortAnswerQuestions(shortAnswerQuestions);

        questionsInfo.setChoiceQuestionsLength(choiceQuestions.size());
        questionsInfo.setCompletionQuestionsLength(completionQuestions.size());
        questionsInfo.setShortAnswerQuestionsLength(shortAnswerQuestions.size());



        return questionsInfo;
    }


    private static String getQuestionIdsStr(List<Questions> list) {
        if (list == null) {
            return "";
        }
        String questionIdsStr = "";
        for (Questions q : list) {
            questionIdsStr = questionIdsStr + "," + q.getqId();
        }
        return questionIdsStr;
    }

}
