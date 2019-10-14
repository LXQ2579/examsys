package com.damo.examsys.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author leizhonggang
 */

@Data
public class Student implements Serializable {

    private Integer stuNum;
    private String stuPwd;
    private String stuName;
    private String stuGender;
    private String stuIdnum;
    private Integer classId;
    private Integer examId;
    private StuInfo stuInfo;

}
