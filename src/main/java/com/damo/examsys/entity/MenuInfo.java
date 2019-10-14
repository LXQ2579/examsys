package com.damo.examsys.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author liujiulong
 * @date 2019/10/12  09:26:00
 */
@Getter
@Setter
public class MenuInfo implements Serializable {

    private Integer menuId;
    private String menuName;
    private String menuUrl;

}
