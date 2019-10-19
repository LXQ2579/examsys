package com.damo.examsys.entity;

import lombok.Data;

import java.io.Serializable;

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
@Data
public class ScoreManage implements Serializable {

    //成绩管理ID
    private Integer scoreId;
    //学号
    private Integer stuNum;
    //学生信息
    private Student student;
    //科目id
    private Integer subjectId;
    //科目信息
    private Subject subject;
    //试卷id
    private Integer paperId;
    //试卷信息
    private Paper paper;
    //考试场次id
    private Integer examlistId;
    //考试场次信息
    private ExamList examList;
    //改卷人id
    private Integer raters;
    //教师信息
    private UserInfo userInfo;
    //改卷状态：0未批改，1已批改
    private Integer scoreState;
    //得分
    private Integer getScore;




}
