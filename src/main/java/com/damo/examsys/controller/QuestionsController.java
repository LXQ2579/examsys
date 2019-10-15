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

    @GetMapping("/gotoList.do")
    public String gotoList(){


        return "after/JudgeQuestionList";
    }

    @PostMapping("/findAll.do")
    @ResponseBody
    public JsonBean findAll(){

        List<Questions> list = questionsService.findAll();

        return new JsonBean<>(0, list);
    }

    @PostMapping("/findById.do")
    @ResponseBody
    public JsonBean findById(Integer qId){

        Questions questions = questionsService.findById(qId);

        return new JsonBean<>(0, questions);
    }

    @PostMapping("/update.do")
    @ResponseBody
    public JsonBean update(Questions questions){

       questionsService.update(questions);

        return new JsonBean<>(0, "试题修改成功");
    }

    @PostMapping("/deleteById.do")
    @ResponseBody
    public JsonBean deleteById(Integer qId){

        questionsService.deleteById(qId);

        return new JsonBean<>(0, "试题删除成功");
    }

    @PostMapping("/add.do")
    @ResponseBody
    public JsonBean add(Questions questions){

        questionsService.add(questions);

        return new JsonBean<>(0, "试题添加成功");
    }

}
