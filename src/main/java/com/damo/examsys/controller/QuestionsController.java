package com.damo.examsys.controller;

import com.damo.examsys.common.JsonBean;
import com.damo.examsys.entity.Questions;
import com.damo.examsys.service.QuestionsService;
import com.damo.examsys.utils.ExcelUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liujiulong
 * @date 2019/10/14  16:01:00
 */
@Controller
@RequestMapping("/questions")
public class QuestionsController {

    @Autowired
    private QuestionsService questionsService;


    @GetMapping("/findAll.do")
    @ResponseBody
    public JsonBean findAll(Integer page, Integer limit, String questionName, Integer typeId, Integer subjectId){

            HashMap<String, Integer> pageMap = new HashMap<>();
            pageMap.put("page", page);
            pageMap.put("limit", limit);

        List<Questions> list = questionsService.findAll(pageMap, questionName, typeId, subjectId);

            long total = ((Page) list).getTotal();


        return new JsonBean<>(0, list, "", (int) total);
    }


    @PostMapping("/import.do")
    @ResponseBody
    public JsonBean<String> importExcel(@RequestParam("file") MultipartFile upfile){

        // 获取上传文件的输入流对象
        try {
            InputStream inputStream = upfile.getInputStream();

            String filename = upfile.getOriginalFilename();
            System.out.println(filename);

            List<Map<String, Object>> list = ExcelUtils.readExcel(filename, inputStream);
//
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonStr = objectMapper.writeValueAsString(list);
            // 将json格式的字符串转为指定类型的对象
            List<Questions> questionList = objectMapper.readValue(jsonStr, new TypeReference<List<Questions>>() {
            });
            System.out.println(questionList);
            questionsService.batchInsert(questionList);
//            System.out.println(ulist);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return new JsonBean<>(0, "导入成功！");
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
