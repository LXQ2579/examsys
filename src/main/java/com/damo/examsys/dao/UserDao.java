package com.damo.examsys.dao;

import com.damo.examsys.entity.User;
import com.github.pagehelper.Page;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author sanriyue
 */
public interface UserDao {
    /**
     * 查找所有的用户信息
     * @return
     */
    Page<User> findAllUser();
}
