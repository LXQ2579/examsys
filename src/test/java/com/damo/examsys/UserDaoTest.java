package com.damo.examsys;

import com.damo.examsys.dao.UserDao;
import com.damo.examsys.entity.User;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.page.PageMethod;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {
    @Autowired
    UserDao userDao;

    @Test
    public void testFindAll(){
        PageHelper.startPage(1, 2);

        PageInfo<User> pageInfo = new PageInfo<>(userDao.findAllUser(0));
        System.out.println(pageInfo);
    }
    @Test
    public void testUpdateAll(){
        String[] strings = {"1","2"};

        Integer integer = userDao.deleteUserByIds(strings,0);
        System.out.println(integer);
    }
}
