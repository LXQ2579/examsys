package com.damo.examsys;

import com.damo.examsys.common.JsonBean;
import com.damo.examsys.controller.StudentController;
import com.damo.examsys.dao.StudentDao;
import com.damo.examsys.entity.Student;
import com.damo.examsys.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author leizhonggang
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentTest {
    @Autowired
    private StudentController studentController;

    @Test
    public void testFindStudentByNum(){
        JsonBean jsonBean = studentController.myStudentInfo(1001);
        System.out.println(jsonBean.getData());

    }

}