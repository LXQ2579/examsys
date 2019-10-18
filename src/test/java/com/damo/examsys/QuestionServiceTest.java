package com.damo.examsys;

import com.damo.examsys.entity.Questions;
import com.damo.examsys.service.QuestionsService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author liujiulong
 * @date 2019/10/14  16:14:00
 */
public class QuestionServiceTest extends ExamsysApplicationTests{

    @Autowired
    private QuestionsService questionsService;

    @Test
    public void testFindByTypeIdAndSubjectId(){
        List<Questions> questions = questionsService.findByTypeIdAndSubjectId(1, 1, 6);
        List<Questions> questions2 = questionsService.findByTypeIdAndSubjectId(2, 1, 6);
        List<Questions> questions3 = questionsService.findByTypeIdAndSubjectId(3, 1, 6);
        String questionIdsStr = getQuestionIdsStr(questions);
        String questionIdsStr1 = getQuestionIdsStr(questions2);
        String questionIdsStr2 = getQuestionIdsStr(questions3);
//        System.out.println(questions.size());
        System.out.println(questionIdsStr);
        System.out.println(questionIdsStr1);
        System.out.println(questionIdsStr2);
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
