package com.damo.examsys.controller;

import com.damo.examsys.common.JsonBean;
import com.damo.examsys.entity.Paper;
import com.damo.examsys.entity.Questions;
import com.damo.examsys.entity.QuestionsInfo;
import com.damo.examsys.service.PaperService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liujiulong
 * @date 2019/10/17  14:24:00
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/paper")
public class PaperController {

    @Autowired
    private PaperService paperService;

    @GetMapping(value = "findAll.do")
    public JsonBean<List<Paper>> findAll(String paperName, Integer subjectId, Integer page, Integer limit) {

        Map<String, Integer> pageMap = new HashMap<>();
        pageMap.put("page", page);
        pageMap.put("limit", limit);

        List<Paper> list = paperService.findAll(pageMap, paperName, subjectId);

        long total = ((Page) list).getTotal();


        return new JsonBean<>(0, list, "试卷遍历成功", (int) total);
    }

    @PostMapping("/findById.do")
    public JsonBean findById(Integer paperId) {

        Paper paper = paperService.findById(paperId);
        return new JsonBean<>(0, paper);
    }

    @PostMapping("/add.do")
    public JsonBean add(Paper paper) {

        paperService.add(paper);
        return new JsonBean<>(0, "试卷生成成功");
    }
    @PostMapping("/update.do")
    public JsonBean update(Paper paper) {

        paperService.update(paper);
        return new JsonBean<>(0, "试卷修改成功");
    }
    @PostMapping("/deleteById.do")
    public JsonBean deleteById(Integer paperId) {

        paperService.deleteById(paperId);
        return new JsonBean<>(0, "试卷删除成功");
    }

    @PostMapping("/getQuestions.do")
    public JsonBean getQuestions(Integer paperId){
        System.out.println(paperId);

        QuestionsInfo questionsInfo = paperService.getQuestions(paperId);
        return new JsonBean<>(0, questionsInfo);
    }

}
