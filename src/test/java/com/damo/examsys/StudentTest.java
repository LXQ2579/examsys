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

import java.util.List;

/**
 * @author leizhonggang
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentTest {
    @Autowired
    private StudentController studentController;
    @Autowired
    private StudentService studentService;

    @Test
    public void testFindStudentByNum(){
        JsonBean jsonBean = studentController.myStudentInfo(1001);
        System.out.println(jsonBean.getData());

    }

    @Test
    public void testAddStu(){
        Student student = new Student();
        student.setStuNum(1006);
        student.setStuPwd("1006");
        student.setStuName("mike");
        student.setStuGender("男");
        student.setStuIdnum("777777888888999999");
        student.setClassId(3);
//        JsonBean jsonBean = studentController.addStu(student);
//        System.out.println(jsonBean.getData());
    }

    @Test
    public void getStudents(){
        List<Student> students = studentService.getStudents();
        for (Student s:students) {
            System.out.println(s);
        }
    }

}
