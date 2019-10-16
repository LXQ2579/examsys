package com.damo.examsys.entity;


import java.io.Serializable;

/**
 * @author liujiulong
 * @date 2019/10/14  14:39:00
 */

public class Subject implements Serializable {

    private Integer sId;
    private String sName;

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }
}
