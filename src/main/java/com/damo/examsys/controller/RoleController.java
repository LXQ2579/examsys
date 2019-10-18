package com.damo.examsys.controller;

import com.damo.examsys.common.JsonBean;
import com.damo.examsys.entity.Role;
import com.damo.examsys.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    /**
     * 获取所有的正常用户
     * @return 正常的用户信息
     */
    @RequestMapping("/allRole.do")
    public JsonBean<List<Role>> allRole(){

        List<Role> allRole = roleService.findAllRole(0);
        return new JsonBean<>(0,allRole);
    }
    @RequestMapping("/allRolePerm.do")
    public JsonBean<List<Role>> allRolePerm(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit){
        return roleService.findAllRolePerm(page, limit, 0);
    }
}
