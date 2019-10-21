package com.damo.examsys.controller;

import com.damo.examsys.common.ErrorCode;
import com.damo.examsys.common.JsonBean;
import com.damo.examsys.dao.StuAnswerDao;
import com.damo.examsys.entity.StuAnswer;
import com.damo.examsys.service.StuAnswerService;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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
 * @Date: 2019/10/21
 */
@Controller
@CrossOrigin
public class StuAnswerController  {

    @Autowired
    private StuAnswerService stuAnswerService;

    /**
     * 获取答案
     * @param stuNum
     * @param paperId
     * @return
     */
    @RequestMapping("/getAnswer")
    @ResponseBody
    public JsonBean<List<StuAnswer>> getAnswer(Integer stuNum,Integer paperId){
        List<StuAnswer> answer = stuAnswerService.getAnswer(stuNum, paperId);
        JsonBean<List<StuAnswer>> jb = new JsonBean<>();
        jb.setData(answer);
        jb.setCode(ErrorCode.SUCCESS);
        return jb;
    }
}
