package com.damo.examsys.controller;

import com.damo.examsys.common.JsonBean;
import com.damo.examsys.entity.QuesType;
import com.damo.examsys.service.QuesTypeService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * @author liujiulong
 * @date 2019/10/15  08:38:00
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/type")
public class QuesTypeController {

    @Autowired
    private QuesTypeService quesTypeService;

    @RequestMapping("/findAll.do")
    @ResponseBody
    public JsonBean findAll(Integer page, Integer limit){

        HashMap<String, Integer> pageMap = new HashMap<>();
        pageMap.put("page", page);
        pageMap.put("limit", limit);

        List<QuesType> list = quesTypeService.findAllPage(pageMap);

        long total = ((Page) list).getTotal();


        return new JsonBean<>(0, list, "试题类型遍历成功", (int) total);
    }

    @PostMapping("/findAll.do")
    @ResponseBody
    public JsonBean findAllSelect(){

        List<QuesType> list = quesTypeService.findAll();

        return new JsonBean<>(0, list);
    }


    @PostMapping("/findById.do")
    @ResponseBody
    public JsonBean findById(Integer quesTypeId){

        QuesType quesType = quesTypeService.findById(quesTypeId);

        return new JsonBean<>(0, quesType);
    }

    @PostMapping("/update.do")
    @ResponseBody
    public JsonBean update(QuesType quesType){

        quesTypeService.update(quesType);

        return new JsonBean<>(0, "试题类型修改成功");
    }

    @PostMapping("/deleteById.do")
    @ResponseBody
    public JsonBean deleteById(Integer quesTypeId){

        quesTypeService.deleteById(quesTypeId);

        return new JsonBean<>(0, "试题类型删除成功");
    }

    @PostMapping("/add.do")
    @ResponseBody
    public JsonBean add(QuesType quesType){

        quesTypeService.add(quesType);

        return new JsonBean<>(0, "试题类型添加成功");
    }

}
