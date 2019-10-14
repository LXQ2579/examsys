package com.damo.examsys.entity;

import lombok.Data;

/**
 * @author leizhonggang
 */

@Data
public class Student {

    private Integer stuNum;
    private String stuPwd;
    private String stuName;
    private String stuGender;
    private String stuIdnum;
    private Integer classId;
    private Integer examId;

}
