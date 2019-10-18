package com.damo.examsys.controller;

import com.alibaba.fastjson.JSONObject;
import com.damo.examsys.common.JsonBean;
import com.damo.examsys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sanriyue
 */
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping("/allUser.do")
    public Map<String,Object> findAllUser(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit){

        return userService.findAllUser(page, limit,0);
    }
    @RequestMapping("/allDelUser.do")
    public Map<String,Object> findAllDelUser(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit){

        return userService.findAllUser(page, limit,1);
    }
    @RequestMapping("/updateUser.do")
    public JsonBean updateUser(@RequestParam HashMap<String, Object> params ){

        return userService.updateUserById(params);

    }
    @RequestMapping("/deleteUser.do")
    public JsonBean deleteUser(@RequestParam Integer uid){

        return userService.deleteUserById(uid,1);
    }
    @RequestMapping("/restoreUser.do")
    public JsonBean restoreUser(@RequestParam Integer uid){

        return userService.deleteUserById(uid,0);
    }
    @RequestMapping("/deleteAll.do")
    public JsonBean deleteAll(@RequestParam String uids){
        String[] uid = uids.split(",");

        return userService.deleteUserByIds(uid,1);
    }
    @RequestMapping("/restoreAll.do")
    public JsonBean restoreAll(@RequestParam String uids){
        String[] uid = uids.split(",");

        return userService.deleteUserByIds(uid,0);
    }

}
