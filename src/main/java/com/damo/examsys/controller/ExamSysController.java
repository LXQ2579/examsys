package com.damo.examsys.controller;

import com.damo.examsys.common.JsonBean;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sanriyue
 */
@RestController
@RequestMapping("/examSys")
public class ExamSysController {

//    @RequiresPermissions("sys:all")
//    @RequestMapping("/manage.do")
//    public JsonBean<> manage(Integer manageId){
//
//    }
}
