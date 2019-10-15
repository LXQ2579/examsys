package com.damo.examsys.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author sanriyue
 */
@Data
public class Menu implements Serializable {
    private String menuId; //主键ID
    private String menuName; //菜单名称
    private String menuUrl;
    private String parentId; //上一级菜单
    private List<Menu> menus; //子菜单列表

}
