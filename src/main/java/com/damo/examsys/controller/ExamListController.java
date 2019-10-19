package com.damo.examsys.controller;

import com.damo.examsys.common.ErrorCode;
import com.damo.examsys.common.JsonBean;
import com.damo.examsys.entity.ExamList;
import com.damo.examsys.entity.Grade;
import com.damo.examsys.entity.Paper;
import com.damo.examsys.service.ExamListService;
import com.github.pagehelper.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *                     .::::.
 *                  .::::::::.
 *                 :::::::::::
 *             ..:::::::::::'
 *           '::::::::::::'
 *             .::::::::::
 *        '::::::::::::::..
 *             ..::::::::::::.
 *           ``::::::::::::::::
 *            ::::``:::::::::'        .:::.
 *           ::::'   ':::::'       .::::::::.
 *         .::::'      ::::     .:::::::'::::.
 *        .:::'       :::::  .:::::::::' ':::::.
 *       .::'        :::::.:::::::::'      ':::::.
 *      .::'         ::::::::::::::'         ``::::.
 *  ...:::           ::::::::::::'              ``::.
 * ```` ':.          ':::::::::'                  ::::..
 *                    '.:::::'                    ':'````..
 *         女神镇楼                 BUG辟易
 *  佛曰:
 *          写字楼里写字间，写字间里程序员；
 *          程序人员写程序，又拿程序换酒钱。
 *          酒醒只在网上坐，酒醉还来网下眠；
 *          酒醉酒醒日复日，网上网下年复年。
 *          但愿老死电脑间，不愿鞠躬老板前；
 *          奔驰宝马贵者趣，公交自行程序员。
 *          别人笑我忒疯癫，我笑自己命太贱；
 *          只见满街漂亮妹，哪个得归程序员？
 * @Description:
 * @Author: lufang.zhang
 * @Date: 2019/10/14
 */
@Api(tags = "考试管理（考试场次管理）")
@CrossOrigin
@Controller
public class ExamListController {

    @Autowired
    private ExamListService examListService;

    @ApiOperation("跳转到考试场次管理页面")
    @RequestMapping("/examListPage")
    public String examListPage(){
        return "after/examList";
    }

    @ApiOperation("查询所有考试")
    @RequestMapping("/examList")
    @ResponseBody
    public JsonBean<List<ExamList>> findExamList(ExamList examList){

        List<ExamList> list = examListService.getExamList(examList);

        JsonBean<List<ExamList>> jb = new JsonBean<>();
        jb.setCode(ErrorCode.SUCCESS);
        jb.setData(list);
        return jb;
    }

    @ApiOperation("删除考试场次信息")
    @RequestMapping("/deleteExam")
    @ResponseBody
    public JsonBean<String> deleteExam(Integer listId){

        examListService.delExam(listId);

        JsonBean<String> jb = new JsonBean<>();
        jb.setCode(ErrorCode.SUCCESS);
        return jb;
    }
    @ApiOperation("根据id查询单个考试场次信息")
    @RequestMapping("/getExamListById")
    @ResponseBody
    public JsonBean<ExamList> getExamListById(Integer listId){

        ExamList examList = examListService.getExamListById(listId);

        JsonBean<ExamList> jb = new JsonBean<>();
        jb.setCode(ErrorCode.SUCCESS);
        jb.setData(examList);
        return jb;
    }

    @ApiOperation("查询所有年级信息")
    @RequestMapping("/getGradeList")
    @ResponseBody
    public JsonBean<List<Grade>> getGradeList(){

        List<Grade> list = examListService.getGradeList();

        JsonBean<List<Grade>> jb = new JsonBean<>();
        jb.setCode(ErrorCode.SUCCESS);
        jb.setData(list);
        return jb;
    }

    @ApiOperation("添加考试场次信息")
    @RequestMapping("/addExam")
    @ResponseBody
    public JsonBean<String> addExam(ExamList examList){

        examListService.addExam(examList);

        JsonBean<String> jb = new JsonBean<>();
        jb.setCode(ErrorCode.SUCCESS);
        jb.setData("添加成功");
        return jb;
    }

    @ApiOperation("修改考试场次信息")
    @RequestMapping("/updateExam")
    @ResponseBody
    public JsonBean<String> updateExam(ExamList examList){

        examListService.updateExam(examList);

        JsonBean<String> jb = new JsonBean<>();
        jb.setCode(ErrorCode.SUCCESS);
        jb.setData("修改成功");
        return jb;
    }

    @ApiOperation("查询所有试卷信息")
    @RequestMapping("/getPaperList")
    @ResponseBody
    public JsonBean<List<Paper>> getPaperList(){

        List<Paper> list = examListService.getPaperList();

        JsonBean<List<Paper>> jb = new JsonBean<>();
        jb.setCode(ErrorCode.SUCCESS);
        jb.setData(list);
        return jb;
    }

    @ApiOperation("获取数据总数")
    @RequestMapping("/getDataCount")
    @ResponseBody
    public JsonBean<Integer> getDataCount(ExamList examList){

        Integer dataCount = examListService.dataCount(examList);

        JsonBean<Integer> jb = new JsonBean<>();
        jb.setCode(ErrorCode.SUCCESS);
        jb.setData(dataCount);
        return jb;
    }

    @GetMapping(value = "/examList/findHasExamList.do")
    @ResponseBody
    public JsonBean findHasExamList(Integer page, Integer limit, String paperName, Integer gradeId, Integer subjectId){
        Map<String, Integer> pageMap = new HashMap<>();
        pageMap.put("page", page);
        pageMap.put("limit", limit);
        List<ExamList> list = examListService.hasExamList(pageMap, paperName, gradeId, subjectId);
        long total = ((Page) list).getTotal();

        return new JsonBean<>(0, list, "已经考过的考试遍历成功", (int) total);
    }


    @GetMapping(value = "/examList/findNotExamList.do")
    @ResponseBody
    public JsonBean findNotExamList(Integer page, Integer limit, String paperName, Integer gradeId, Integer subjectId){
        Map<String, Integer> pageMap = new HashMap<>();
        pageMap.put("page", page);
        pageMap.put("limit", limit);
        List<ExamList> list = examListService.notExamList(pageMap, paperName, gradeId, subjectId);
        long total = ((Page) list).getTotal();

        return new JsonBean<>(0, list, "已经考过的考试遍历成功", (int) total);
    }
}
