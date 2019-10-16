package com.damo.examsys.controller;

import com.damo.examsys.common.JsonBean;
import com.damo.examsys.entity.QuesType;
import com.damo.examsys.service.QuestionsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author liujiulong
 * @date 2019/10/15  08:38:00
 */
@RestController
@RequestMapping(value = "/type")
public class QuestionsTypeController {

    @Autowired
    private QuestionsTypeService questionsTypeService;

    @RequestMapping("/findAll.do")
    public JsonBean findAll(){

        List<QuesType> list = questionsTypeService.findAll();


        return new JsonBean<>(0, list);
    }
}
