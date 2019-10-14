package com.damo.examsys.entity;

import lombok.Data;

import java.io.Serializable;


/**
 * @author liujiulong
 * @date 2019/10/14  14:45:00
 */
@Data
public class Questions implements Serializable {

    private Integer qId;
    private String title;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String standardAnswer;
    private String answerDetail;
    private Integer subjectId;
    private Subject subject;
    //类型编号: 0 为 选择题, 1 为 判断题, 2 为简答题
    private Integer typeId;
    private QuestionsType questionsType;
    private String remark;
    private Integer score;

}
