package com.damo.examsys.entity;

import java.io.Serializable;

/**
 * @author liujiulong
 * @date 2019/10/16  09:22:00
 */
public class QuesType implements Serializable {

    private Integer quesTypeId;
    private String quesTypeName;

    public Integer getQuesTypeId() {
        return quesTypeId;
    }

    public void setQuesTypeId(Integer quesTypeId) {
        this.quesTypeId = quesTypeId;
    }

    public String getQuesTypeName() {
        return quesTypeName;
    }

    public void setQuesTypeName(String quesTypeName) {
        this.quesTypeName = quesTypeName;
    }
}
