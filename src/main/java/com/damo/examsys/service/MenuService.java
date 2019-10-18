package com.damo.examsys.service;

import com.damo.examsys.entity.Menu;
import com.damo.examsys.entity.MenuModule;

import java.util.HashMap;
import java.util.List;

/**
 * @author sanriyue
 */
public interface MenuService {
    /**
     * 返回分目录菜单
     * @param menuId 所要查询根目录的Id
     * @return 菜单类
     */
    Menu getMenu(Integer menuId);



    /**
     * 获取所有的根菜单
     *
     * @return 所欧根
     */
    String getRootMenu();


    /**
     * 返回前台分目录菜单
     * @param menuId 所要查询根目录的Id
     * @return 菜单类
     */
    Menu getBeforeMenu(Integer menuId);


    /**
     * 获取前台所有的根菜单
     *
     * @return 所欧根
     */
    String getBeforeRootMenu();
}
