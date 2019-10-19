package com.damo.examsys.service.impl;

import com.damo.examsys.dao.ScoreManageDao;
import com.damo.examsys.entity.ScoreManage;
import com.damo.examsys.service.ScoreManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
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
 * @Date: 2019/10/18
 */
@Service
@Transactional
public class ScoreManageServiceImpl  implements ScoreManageService {


    @Autowired(required = false)
    private ScoreManageDao scoreManageDao;

    /**
     * 查找所有考生的试卷信息
     * @return
     */
    public List<ScoreManage> findAllExamScore(HashMap<String, Object> condition){
        Integer pageFirst = (Integer.valueOf(condition.get("page").toString()) - 1)*Integer.valueOf(condition.get("limit").toString());
        condition.put("page",pageFirst);
        condition.put("limit",Integer.valueOf(condition.get("limit").toString()));
        return scoreManageDao.findAllExamScore(condition);
    }

    /**
     *
     * @param condition
     * @return
     */
    public Integer findDataCount(HashMap<String, Object> condition){
        return scoreManageDao.findDataCount(condition);
    }

}
