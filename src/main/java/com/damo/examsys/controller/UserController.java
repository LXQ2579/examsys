package com.damo.examsys.controller;

import com.damo.examsys.common.JsonBean;
import com.damo.examsys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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

        return userService.findAllUser(page, limit);
    }

    @RequestMapping("/updateUser.do")
    public JsonBean updateUser(@RequestParam HashMap<String, Object> params ){

        return userService.updateUserById(params);

    }
    @RequestMapping("/deleteUser.do")
    public JsonBean deleteUser(@RequestParam Integer uid){

        return userService.deleteUserById(uid);
    }

}
