package com.damo.examsys.controller;

import com.damo.examsys.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sanriyue
 */
@CrossOrigin
@RestController
@RequestMapping("/examSys")
public class ExamSysController {
    @Autowired
    MenuService menuService;

//    @RequiresPermissions("sys:all")


    @RequestMapping("/noPerms")
    public String noPerms(){
        return "您没有权限";
    }
}
