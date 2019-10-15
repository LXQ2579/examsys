package com.damo.examsys.controller;

import com.damo.examsys.common.CodeMsg;
import com.damo.examsys.common.ErrorCode;
import com.damo.examsys.common.JsonBean;
import com.damo.examsys.entity.Class;
import com.damo.examsys.entity.Student;
import com.damo.examsys.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.spring.web.json.Json;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private CodeMsg codeMsg;
    @Autowired
    private StudentService studentService;

    @RequestMapping("/myInfo.do")
    @ResponseBody
    public JsonBean myStudentInfo(Integer stuNum){

        Student student = studentService.findStuByNum(stuNum);
        if (student == null){
            return new JsonBean(ErrorCode.STUDENT_NULL,codeMsg.getStudentNull());
        }
        return new JsonBean(0,student);
    }

    @RequestMapping("/stuInfo.do")
    public String goStuInfo(){
        return "before/studentInfo";
    }

    @RequestMapping("/toAddStu.do")

    public String goToAdd(){
        return "before/addStudent";
    }

    @PostMapping("/addStu.do")
    public String addStu(Student student){
        JsonBean jsonBean = studentService.addStudent(student);
        if (jsonBean.getCode()==0){
        return "index";
        }
        return null;
    }

    @RequestMapping("/getClass.do")
    @ResponseBody
    public JsonBean classList(){
        List<Class> list = studentService.classList();
        return new JsonBean(0,list);
    }

}
