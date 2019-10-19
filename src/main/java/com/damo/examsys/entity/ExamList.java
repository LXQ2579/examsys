package com.damo.examsys.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

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
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")
    private Date beginTime;
    //结束时间
    @ApiModelProperty("结束时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")
    private Date endTime;
    //年级id
    @ApiModelProperty("年级id")
    private Integer gradeId;
    //年级名
    @ApiModelProperty("年级名")
    private String gradeName;
    //考试科目id
    @ApiModelProperty("考试科目id")
    private Integer subjectId;
    //考试科目
    @ApiModelProperty("考试科目")
    private String sName;
    //考试地点
    @ApiModelProperty("考试地点")
    private String examAddress;
    //监考老师id
    @ApiModelProperty("监考老师id")
    private Integer invigilator;
    //监考老师
    @ApiModelProperty("监考老师")
    private String uName;
    //操作人id
    @ApiModelProperty("操作人id")
    private Integer operatorId;
    //试卷id
    @ApiModelProperty("试卷id")
    private Integer paperId;
    //试卷名称
    @ApiModelProperty("试卷名称")
    private String paperName;


    //当前页码
    @ApiModelProperty("查询条件时使用的：当前页码")
    private Integer pageNum;

    //从第几条开始从查起
    @ApiModelProperty("查询条件时使用的：从第几条开始从查起")
    private Integer firstNum;

    //每页显示条数
    @ApiModelProperty("查询条件时使用的：每页显示条数")
    private Integer pageSize;

    private Long remainTime;


}
