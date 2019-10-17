package com.damo.examsys.controller;

import com.damo.examsys.common.JsonBean;
import com.damo.examsys.entity.Subject;
import com.damo.examsys.service.SubjectService;
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
@RequestMapping(value = "/subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @GetMapping("/findAll.do")
    @ResponseBody
    public JsonBean findAll(Integer page, Integer limit){

        HashMap<String, Integer> pageMap = new HashMap<>();
        pageMap.put("page", page);
        pageMap.put("limit", limit);

        List<Subject> list = subjectService.findAllPage(pageMap);

        long total = ((Page) list).getTotal();

        return new JsonBean<>(0, list, "科目遍历成功", (int) total);
    }

    @PostMapping("/findAll.do")
    @ResponseBody
    public JsonBean findAllSelect(){
        List<Subject> list = subjectService.findAll();
        return new JsonBean<>(0, list);
    }



    @PostMapping("/findById.do")
    @ResponseBody
    public JsonBean findById(Integer subjectId){

        Subject subject = subjectService.findById(subjectId);

        return new JsonBean<>(0, subject);
    }

    @PostMapping("/update.do")
    @ResponseBody
    public JsonBean update(Subject subject){

        subjectService.update(subject);

        return new JsonBean<>(0, "科目修改成功");
    }

    @PostMapping("/deleteById.do")
    @ResponseBody
    public JsonBean deleteById(Integer subjectId){

        subjectService.deleteById(subjectId);

        return new JsonBean<>(0, "科目删除成功");
    }

    @PostMapping("/add.do")
    @ResponseBody
    public JsonBean add(Subject subject){

        subjectService.add(subject);

        return new JsonBean<>(0, "科目添加成功");
    }
}
