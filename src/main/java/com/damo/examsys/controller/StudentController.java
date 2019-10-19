package com.damo.examsys.controller;

import com.damo.examsys.common.CodeMsg;
import com.damo.examsys.common.ErrorCode;
import com.damo.examsys.common.JsonBean;
import com.damo.examsys.entity.Class;
import com.damo.examsys.entity.Student;
import com.damo.examsys.service.StudentService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@Controller
@CrossOrigin
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
    @ResponseBody
    public JsonBean addStu(Student student){
        JsonBean jsonBean = studentService.addStudent(student);
       return jsonBean;
    }

    @RequestMapping("/getClass.do")
    @ResponseBody
    public JsonBean classList(){
        List<Class> list = studentService.classList();
        return new JsonBean(0,list);
    }

    @RequestMapping("/getUpdateInfo.do")
    public String getStuPageInfo(Student student){

        return "after/updateStudent";
    }

    @RequestMapping("/delStu.do")
    @ResponseBody
    public JsonBean delStudent(HttpServletRequest request){
        String stuNum = request.getParameter("stuNum");
        studentService.deleteStudent(Integer.parseInt(stuNum));
        JsonBean jsonBean = new JsonBean();
        jsonBean.setCode(0);
        jsonBean.setData("删除成功");
        return jsonBean;
    }

    @RequestMapping("/stuList.do")
    @ResponseBody
    public JsonBean stuList(Integer page, Integer limit, Integer stuNum, String stuName, Integer classId){

        HashMap<String, Integer> pageMap = new HashMap<>();
        pageMap.put("page", page);
        pageMap.put("limit", limit);

        List<Student> students = studentService.getStudents(pageMap, stuNum, stuName, classId);
        long total = ((Page) students).getTotal();
        return new JsonBean<List<Student>>(0,students, "查询成功", (int)total);
    }

    @PostMapping("/updateStu.do")
    @ResponseBody
    public JsonBean updateStudent(Student student){
        studentService.updateStudent(student);
        return new JsonBean(0,"修改成功");
    }

    @RequestMapping("/goToStuList.do")
    public String goToStuList(){
        return "after/stuList";
    }

}
