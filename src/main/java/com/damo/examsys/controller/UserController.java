package com.damo.examsys.controller;

import com.damo.examsys.common.JsonBean;
import com.damo.examsys.entity.User;
import com.damo.examsys.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
        Map<String, Object> allUser = userService.findAllUser(page, limit);

        return allUser;
    }

    @PostMapping("/updateUser.do")
    public JsonBean updateUser(@RequestBody String data, HttpServletRequest request){
        System.out.println(1);
        System.out.println(data);
        return new JsonBean<>(0,"1234");

    }

}
