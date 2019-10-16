package com.damo.examsys.controller;

import com.damo.examsys.common.JsonBean;
import com.damo.examsys.entity.Subject;
import com.damo.examsys.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author liujiulong
 * @date 2019/10/15  08:38:00
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @RequestMapping("/findAll.do")
    public JsonBean findAll(){

        List<Subject> list = subjectService.findAll();


        return new JsonBean<>(0, list);
    }
}
