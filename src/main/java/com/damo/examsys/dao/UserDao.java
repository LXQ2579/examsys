package com.damo.examsys.dao;

import com.damo.examsys.entity.Class;
import com.damo.examsys.entity.Student;
import com.damo.examsys.entity.User;
import com.damo.examsys.entity.UserInfo;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;

/**
 * @author sanriyue
 */
@Repository
public interface UserDao {
    /**
     * 查找所有的用户信息
     * @return
     */
    Page<User> findAllUser(Integer isDeleted);

    /**
     * 根据用户的ID更新用户的信息
     * @param map
     * @return
     */
    Integer updateUserInfo(HashMap map);

    Integer deleteUserById(Integer uid,Integer isDeleted);

    Integer deleteUserByIds(String [] uid,Integer isDeleted);

    /**
     * 通过userid查找userInfo
     * @param uid
     * @return
     */
    UserInfo findUserInfoByUid(Integer uid);



    //老师登录
    public User findByName(String name);
    //获取登录用户权限信息列表
    public List<String> findPermsByName(String name);
    //学生登陆
    public Student findByStuName(String name);
    //教师注册
    public void addUser(String uname,String password);
    //添加uid、rid到urid
    public void addId(Integer uid,Integer rid);
    //学生注册
//    public void addStu(String stuNum,String stuPwd,String stuName,String stuGender,String stuIdNum,Integer classId);
    public void addStu(Student stu);
    //查询班级id
    public Class findByClassName(String className);
    //添加user信息
    public void addUserInfo(String name,Integer userId,String sex);
    //通过ur表查询rid
    public List<Integer> findByUid(Integer uid);
    //查询所有角色
    public List<String> findAllRoles();
}
