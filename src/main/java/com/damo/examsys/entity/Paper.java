package com.damo.examsys.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @author liujiulong
 * @date 2019/10/14  14:36:00
 */
@Getter
@Setter
public class Paper implements Serializable {

    private Integer paperId;
    private String paperName;
    private Integer subjectId;
    private String subjectName;
    private Subject subject;
    private String questionIds;
    private List<Questions> questions;
    private Integer allowTime;
    private String remark;
    private Integer score;
    private Integer state;

}

