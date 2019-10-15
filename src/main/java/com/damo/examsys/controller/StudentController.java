package com.damo.examsys.controller;

import com.damo.examsys.common.CodeMsg;
import com.damo.examsys.common.ErrorCode;
import com.damo.examsys.common.JsonBean;
import com.damo.examsys.entity.Student;
import com.damo.examsys.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private CodeMsg codeMsg;
    @Autowired
    private StudentService studentService;

    @RequestMapping("/myInfo")
    @ResponseBody
    public JsonBean myStudentInfo(Integer stuNum){

        Student student = studentService.findStuByNum(stuNum);
        if (student == null){
            return new JsonBean(ErrorCode.STUDENT_NULL,codeMsg.getStudentNull());
        }
        return new JsonBean(0,student);
    }

    @RequestMapping("/stuInfo")
    public String goStuInfo(){
        return "before/studentInfo";
    }

}
