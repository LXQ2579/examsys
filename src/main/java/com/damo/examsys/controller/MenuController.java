package com.damo.examsys.controller;

import com.alibaba.fastjson.JSON;
import com.damo.examsys.common.IndexInit;
import com.damo.examsys.common.JsonBean;
import com.damo.examsys.entity.Menu;
import com.damo.examsys.entity.MenuModule;
import com.damo.examsys.service.MenuService;
import com.damo.examsys.utils.IndexInitUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * @author sanriyue
 */
@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    MenuService menuService;
    @Autowired
    IndexInitUtils indexInitUtils;

    @CrossOrigin
    @GetMapping("/rootMenu.do")
    public String rootMenu(){

        String rootMenu = menuService.getRootMenu();

        return indexInitUtils.indexInit(rootMenu);

    }
    @CrossOrigin
    @GetMapping("/getMenu.do")
    public JsonBean<Menu> getMenu(String menuId){

        return new JsonBean<>(0,menuService.getMenu(1));
    }

    @CrossOrigin
    @GetMapping("/beforeRootMenu.do")
    public String beforeRootMenu(){

        String rootMenu = menuService.getBeforeRootMenu();

        return indexInitUtils.indexInit(rootMenu);

    }

    @CrossOrigin
    @GetMapping("/getBeforeMenu.do")
    public JsonBean<Menu> getBeforeMenu(String menuId){

        return new JsonBean<>(0,menuService.getBeforeMenu(1));
    }



}
