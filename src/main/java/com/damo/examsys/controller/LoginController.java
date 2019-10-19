package com.damo.examsys.controller;

import com.damo.examsys.common.JsonBean;
import com.damo.examsys.entity.Class;
import com.damo.examsys.entity.Student;
import com.damo.examsys.entity.User;
import com.damo.examsys.service.ClassService;
import com.damo.examsys.service.RoleService;
import com.damo.examsys.service.StuService;
import com.damo.examsys.service.UserService;
import com.damo.examsys.utils.MD5Utils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private ClassService classService;
    @Autowired
    private StuService stuService;
    @Autowired
    private RoleService roleService;


    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String loginPage(){
        return "after/loginUser";
    }

    @RequestMapping("/findAllRoles")
    @ResponseBody
    public JsonBean findAllRoles(){
        List<String>list = userService.findAllRoles();
        return new JsonBean(0,list);
    }
    //登录
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public JsonBean loginUser(String uname, String password, String rdesc){

        if(rdesc.equals("学生")){
            String stuName=uname;

            if(stuName==null||stuName.equals("")){
                return new JsonBean(1,"用户名不能为空");
            }else if(password==null||password.equals("")){
                return new JsonBean(1,"密码不能为空");
            }else {
                Student stu = userService.findByStuName(stuName);
                if(stu==null){
                    return new JsonBean(1,"该用户不存在，请注册后登录");
                }else if(!stu.getStuPwd().equals(password)){
                    return new JsonBean(1,"密码不正确");
                }else{

                    String token = MD5Utils.md5(stu.getStuName() + "haha");

                    stringRedisTemplate.opsForValue().set(token,stu.getStuName());
                    stringRedisTemplate.expire(token,30, TimeUnit.MINUTES);
                    return new JsonBean(0,rdesc);
                }
            }
        }else{
            User user = userService.findByName(uname);
            if(user==null){
                return new JsonBean(1,"该用户不存在，请注册后登录");
            }
            if(uname==null||uname.equals("")||password==null||password.equals("")){
                return new JsonBean(1,"用户名密码不能为空");
            }
            if(user.getIsDeleted()==1){
                return new JsonBean(1,"该用户已被冻结");
            }
        else{

                User u = userService.findByName(uname);
                Integer uid = u.getUid();

                List<Integer> ridList = userService.findByUid(uid);

                Integer rid = roleService.findByRdesc(rdesc);

                if(!ridList.contains(rid) ){

                    return new JsonBean(1,"职位不匹配");
                }else{
                //存储输入用户名密码
                    UsernamePasswordToken token=new UsernamePasswordToken(uname,password);
                    //获得主题对象
                    Subject subject = SecurityUtils.getSubject();
                    try{
                        subject.login(token);
                        subject.getSession().setAttribute("user",user);
                        return new JsonBean<>(0,rdesc);
                    }catch (Exception e){
                        e.printStackTrace();
                       return new JsonBean(1,null);
                    }
                }
            }
        }
    }


    @RequestMapping(value = "/addStu",method = RequestMethod.GET)
    public String addStu(){
        return "after/registerStu";
    }

    //查询所有班级（下拉框）
    @ResponseBody
    @RequestMapping("/findAllClass")
    public JsonBean findAllClass(){
        List<String> list = classService.findAllClass();
        return new JsonBean(0,list);
    }

    //注册stu
    @ResponseBody
    @RequestMapping("/addStu")
    public JsonBean addStu(Student stu, String className){
        Student stu1 = userService.findByStuName(stu.getStuName());
        if(stu1==null){
            Class class1 = stuService.findByClassName(className);

            Integer classId = class1.getClassId();
            stu.setClassId(classId);
            stuService.addStu(stu);
            return new JsonBean(0,"注册成功");
        }else{
            return new JsonBean(1,"该用户已存在");
        }
    }
}
