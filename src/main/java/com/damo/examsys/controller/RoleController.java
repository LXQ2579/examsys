package com.damo.examsys.controller;

import com.damo.examsys.common.JsonBean;
import com.damo.examsys.entity.Role;
import com.damo.examsys.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping("/updateRole.do")
    public JsonBean<String> updateRole(Role role){
        return roleService.updateRole(role);
    }

    @RequestMapping("/deleteRole.do")
    public JsonBean<String> deleteRole(@RequestParam Integer rid){

        return roleService.deleteRole(rid,1);
    }

    @RequestMapping("/restoreRole.do")
    public JsonBean<String> restoreRole(@RequestParam Integer rid){

        return roleService.deleteRole(rid,0);
    }

    @RequestMapping("/deleteAll.do")
    public JsonBean<String> deletedAll(@RequestParam String rids){
        String[] split = rids.split(",");
        for (String s : split) {
            System.out.println(s);
        }
        return  roleService.deleteAllRole(split,1);
    }
}


