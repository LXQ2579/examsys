package com.damo.examsys.controller;

import com.damo.examsys.common.CodeMsg;
import com.damo.examsys.common.ErrorCode;
import com.damo.examsys.common.JsonBean;
import com.damo.examsys.entity.Student;
import com.damo.examsys.entity.SubExamInfo;
import com.damo.examsys.entity.Subject;
import com.damo.examsys.service.StudentService;
import com.damo.examsys.service.SubExamInfoService;
import com.github.pagehelper.Page;
import org.aspectj.apache.bcel.classfile.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
@CrossOrigin
@Controller
@RequestMapping("/subInfo")
public class SubExamInfoController {
    @Autowired
    CodeMsg codeMsg;

    @Autowired
    SubExamInfoService subExamInfoService;
    @Autowired
    StudentService studentService;

    @RequestMapping("/subName.do")
    @ResponseBody
    public JsonBean findSubNames(){
        List<Subject> subNames = subExamInfoService.findSubNames();
        return new JsonBean(0,subNames);
    }

    @RequestMapping("/subInfo.do")
    @ResponseBody
    public JsonBean findSubInfo(Integer subjectId){
        List<SubExamInfo> allSubInfo = subExamInfoService.findAllSubInfo(subjectId);
        return new JsonBean(0,allSubInfo);
    }


    @RequestMapping("/subjectInfo.do")
    @ResponseBody
    public JsonBean findAllSubInfo(Integer page, Integer limit,Integer sId){
        HashMap<String, Integer> pageMap = new HashMap<>();
        pageMap.put("page", page);
        pageMap.put("limit", limit);

        List<SubExamInfo> allSubInfo = subExamInfoService.findSubInfo(pageMap,sId);
        long total = ((Page) allSubInfo).getTotal();
        return new JsonBean<List<SubExamInfo>>(0,allSubInfo, "查询成功", (int)total);
    }

    @RequestMapping("/chooseSub.do")
    @ResponseBody
    public JsonBean chooseSubject(Integer listId,Integer stuNum){
        Student stuByNum = studentService.findStuByNum(stuNum);
        if (stuByNum.getExamId() != null){
            return new JsonBean(ErrorCode.EXAM_ALREADY, codeMsg.getExamAlready());
        }

        subExamInfoService.chooseSubject(listId, stuNum);
        return new JsonBean(0,"选考成功");
    }
}
