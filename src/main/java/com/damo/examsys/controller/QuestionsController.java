package com.damo.examsys.controller;

import com.damo.examsys.common.JsonBean;
import com.damo.examsys.entity.Questions;
import com.damo.examsys.service.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author liujiulong
 * @date 2019/10/14  16:01:00
 */
@Controller
@RequestMapping("/questions")
public class QuestionsController {

    @Autowired
    private QuestionsService questionsService;

    @PostMapping("/findAll.do")
    public JsonBean findAll(){

        List<Questions> list = questionsService.findAll();

        return new JsonBean<List<Questions>>(0, list);
    }

}