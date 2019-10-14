package com.damo.examsys.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author liujiulong
 * @date 2019/10/14  14:36:00
 */
@Getter
@Setter
public class Paper implements Serializable {

    private Integer pId;
    private String pName;
    private Integer subjectId;
    private Integer state;
    private Date allowTime;
    private String remark;
    private Integer totalScore;
    private List<Questions> questions;

}

