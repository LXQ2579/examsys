package com.damo.examsys.dao;

import com.damo.examsys.entity.User;

import java.util.List;

/**
 * @author sanriyue
 */
public interface UserDao {
    /**
     * 查找所有的用户信息
     * @return
     */
    List<User> findAllUser();
}
