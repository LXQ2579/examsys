package com.damo.examsys.service.impl;

import com.damo.examsys.dao.QuestionsDao;
import com.damo.examsys.dao.QuesTypeDao;
import com.damo.examsys.dao.SubjectDao;
import com.damo.examsys.entity.Questions;
import com.damo.examsys.service.QuestionsService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author liujiulong
 * @date 2019/10/14  15:58:00
 */
@Service
public class QuestionsServiceImpl implements QuestionsService {

    @Autowired
    private QuestionsDao questionsDao;

    @Autowired
    private QuesTypeDao quesTypeDao;

    @Autowired
    private SubjectDao subjectDao;


    @Override
    public List<Questions> findAll(Map<String, Integer> pageMap, String questionName, Integer typeId, Integer subjectId) {
        PageHelper.startPage(pageMap.get("page"), pageMap.get("limit"));
        return questionsDao.findAll(questionName, typeId, subjectId);
    }

    @Override
    public Questions findById(Integer qId) {
        return questionsDao.findById(qId);
    }

    @Override
    public void update(Questions questions) {
        questionsDao.update(questions);
    }

    @Override
    public void deleteById(Integer qId) {
        questionsDao.deleteById(qId);
    }

    @Override
    public void add(Questions questions) {
        questionsDao.add(questions);
    }

    @Override
    public void batchInsert(List<Questions> questionsList) {
        //设置导入试题的typeId和subjectId
        for (Questions q : questionsList) {
            Integer subjectId = subjectDao.findByName(q.getSubjectName()).getsId();
            if ( subjectId != null){
                q.setSubjectId(subjectId);
            }
            String quesTypeName = q.getQuesTypeName();
            if (quesTypeName != null){

                Integer quesTypeId = quesTypeDao.findByName(quesTypeName).getQuesTypeId();
                if (quesTypeId != null){
                    q.setTypeId(quesTypeId);
                }
            }
        }
        questionsDao.batchInsert(questionsList);
    }

    @Override
    public List<Questions> findByTypeIdAndSubjectId(Integer typeId, Integer subjectId, Integer count) {

        if(count < 0){
            throw  new RuntimeException("题目数量不能为负数");
        }
        if (count == 0 ){
            return null;
        }
        return questionsDao.findByTypeIdAndSubjectId(typeId, subjectId, count);
    }
}
