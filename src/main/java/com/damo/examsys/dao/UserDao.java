package com.damo.examsys.dao;

import com.damo.examsys.entity.User;
import com.github.pagehelper.Page;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;

/**
 * @author sanriyue
 */
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
}
