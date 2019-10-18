package com.damo.examsys.dao;

import com.damo.examsys.entity.Menu;
import com.damo.examsys.entity.MenuModule;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author sanriyue
 */
@Repository
public interface MenuDao {
    /**
     * 返回分目录菜单
     *
     * @param menuId 所要查询根目录的Id
     * @return 菜单类
     */
    Menu getMenu(Integer menuId);

    /**
     * 根据父类ID返回所有的子类菜单
     *
     * @param parentId 父类ID
     * @return 子类菜单
     */
    List<Menu> findMenuByParentId(Integer parentId);


    /**
     * 获取所有的目录
     * @return 所有的目录信息
     */
    List<MenuModule> getRootMenu();

    /**
     *
     * @param menuModuleId
     * @return
     */
    List<Menu> findMenuByModuleId(Integer menuModuleId);




    /**
     * 返回前台分目录菜单
     *
     * @param menuId 所要查询根目录的Id
     * @return 菜单类
     */
    Menu getBeforeMenu(Integer menuId);


    /**
     * 获取前台所有的目录
     * @return 所有的目录信息
     */
    List<MenuModule> getBeforeRootMenu();


    /**
     * 根据父类ID返回所有的子类菜单
     *
     * @param parentId 父类ID
     * @return 子类菜单
     */
    List<Menu> findBeforeMenuByParentId(Integer parentId);


    /**
     *
     * @param menuModuleId
     * @return
     */
    List<Menu> findBeforeMenuByModuleId(Integer menuModuleId);
}
