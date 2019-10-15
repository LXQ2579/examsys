package com.damo.examsys.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author liujiulong
 * @date 2019/10/14  15:54:00
 */
public class QuestionsType {

    private Integer tId;
    private String tName;

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }
}
