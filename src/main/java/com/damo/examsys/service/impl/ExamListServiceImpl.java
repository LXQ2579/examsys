package com.damo.examsys.service.impl;

import com.damo.examsys.dao.ExamListDao;
import com.damo.examsys.entity.ExamList;
import com.damo.examsys.service.ExamListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
 * @Date: 2019/10/14
 */
@Transactional
@Service
public class ExamListServiceImpl implements ExamListService {

    @Autowired(required = false)
    private ExamListDao examListDao;

    /**
     * 获取所有考试场次
     * @return
     */
    @Override
    public List<ExamList> getExamList() {
        return examListDao.getExamList();
    }

    /**
     * 添加考试场次信息
     * @param examList
     */
    @Override
    public void addExam(ExamList examList) {

    }

    /**
     * 修改考试场次信息
     * @param examList
     */
    @Override
    public void updateExam(ExamList examList) {

    }

    /**
     * 根据id删除考试场次
     * @param listId
     */
    @Override
    public void delExam(Integer listId) {

    }
}
