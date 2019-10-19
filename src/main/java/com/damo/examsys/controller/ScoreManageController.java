package com.damo.examsys.controller;

import com.damo.examsys.common.ErrorCode;
import com.damo.examsys.common.JsonBean;
import com.damo.examsys.entity.ScoreManage;
import com.damo.examsys.service.ScoreManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
 * @Date: 2019/10/18
 */
@CrossOrigin
@Controller
public class ScoreManageController {

    @Autowired
    private ScoreManageService scoreManageService;

    @GetMapping("/scoreManage")
    public String toScoreManage(){
        return "after/scoreManage";
    }

    /**
     * 查找所有考生的试卷信息
     * @return
     */
    @ResponseBody
    @RequestMapping("/findAllExamInfo")
   public JsonBean<List<ScoreManage>> findAllExamScore(@RequestParam HashMap<String, Object> condition){

        System.out.println(condition.toString());
        List<ScoreManage> scoreManageList = scoreManageService.findAllExamScore(condition);

        JsonBean<List<ScoreManage>> jb = new JsonBean<>();
        jb.setCode(ErrorCode.SUCCESS);
        jb.setMsg("hahh");
        jb.setCount(scoreManageService.findDataCount(condition));
        jb.setData(scoreManageList);
        return jb;

    }


}
