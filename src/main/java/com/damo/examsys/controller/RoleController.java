package com.damo.examsys.controller;

import com.damo.examsys.common.JsonBean;
import com.damo.examsys.entity.Role;
import com.damo.examsys.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author sanriyue
 */
@CrossOrigin
@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    RoleService roleService;

    @RequestMapping("/allRole.do")
    public JsonBean<List<Role>> allRole(){
        System.out.println(111);
        List<Role> allRole = roleService.findAllRole();
        return new JsonBean<>(0,allRole);
    }
}
