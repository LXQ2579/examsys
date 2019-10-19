package com.damo.examsys.service;

import com.damo.examsys.common.JsonBean;
import com.damo.examsys.entity.Class;
import com.damo.examsys.entity.Student;
import com.damo.examsys.entity.User;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sanriyue
 */

public interface UserService {
    Map<String,Object> findAllUser (int pageNum, int pageSize,Integer isDeleted);

    JsonBean updateUserById(HashMap<String, Object> map);

    JsonBean deleteUserById(Integer uid , Integer isDeleted);

    JsonBean deleteUserByIds(String [] uid,Integer isDeleted);


    //查询user
    public User findByName(String uname);
    //查询权限
    public List<String> findPermsByName(String name);
    //查询stu
    public Student findByStuName(String name);
    //注册user
    public void addUser(String uname,String password);
    //添加uid rid到urid
    public void addId(Integer uid,Integer rid);
    //查询班级信息
    public Class findByClassName(String className);
    //添加userInfo
    public void addUserIfo(String name,Integer userId,String sex);
    //通过ur表查询rid
    public List<Integer> findByUid(Integer uid);
    //查询所有角色
    public List<String> findAllRoles();
}
