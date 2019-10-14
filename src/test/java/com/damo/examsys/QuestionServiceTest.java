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
    public void testFindAll(){

        List<Questions> list = questionsService.findAll();

        System.out.println(list);
    }

}
