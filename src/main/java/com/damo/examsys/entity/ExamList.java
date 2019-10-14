package com.damo.examsys.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

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
 *
 *
 *
 * @Description: 考试场次实体类
 * @Author: lufang.zhang
 * @Date: 2019/10/14
 */
@ApiModel("考试场次信息")
@Data
public class ExamList implements Serializable {
    //考试场次id
    @ApiModelProperty("考试场次id")
    private Integer listId;
    //考试开始时间
    @ApiModelProperty("考试开始时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date beginTime;
    //结束时间
    @ApiModelProperty("结束时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date endTime;
    //年级id
    @ApiModelProperty("年级id")
    private Integer gradeId;
    //考试科目id
    @ApiModelProperty("考试科目id")
    private Integer subjectId;
    //考试地点
    @ApiModelProperty("考试地点")
    private String examAddress;
    //监考老师id
    @ApiModelProperty("监考老师id")
    private Integer Invigilator;
    //操作人id
    @ApiModelProperty("操作人id")
    private Integer operatorId;


}
