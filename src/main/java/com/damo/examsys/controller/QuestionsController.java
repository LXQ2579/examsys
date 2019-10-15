package com.damo.examsys.controller;

import com.damo.examsys.common.JsonBean;
import com.damo.examsys.entity.Questions;
import com.damo.examsys.service.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @ResponseBody
    public JsonBean findAll(){

        List<Questions> list = questionsService.findAll();

        return new JsonBean<>(0, list);
    }

    @GetMapping("/gotoList.do")
    public String gotoList(){


        return "after/questionList";
    }

}
