package com.damo.examsys.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author liujiulong
 * @date 2019/10/14  14:39:00
 */
@Getter
@Setter
public class Subject implements Serializable {

    private Integer sId;
    private String sName;

}
