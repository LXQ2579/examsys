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

import javax.servlet.http.HttpServletRequest;
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
        return "before/test";
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

//    @RequestMapping("/goToUpdate.do")
//    public String  goUpdate(){
//
//        return "before/updateStudent";
//    }

    @RequestMapping("/getUpdateInfo.do")
    public String getStuPageInfo(Student student){

        System.out.println(student.getStuNum());
        System.out.println(student.getStuName());
        return "before/updateStudent";
    }

    @RequestMapping("/delStu.do")
    @ResponseBody
    public JsonBean delStudent(HttpServletRequest request){
        String stuNum = request.getParameter("stuNum");
        JsonBean jsonBean = studentService.deleteStudent(Integer.parseInt(stuNum));
        return jsonBean;
    }


}
