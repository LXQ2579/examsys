package com.damo.examsys;

import com.damo.examsys.dao.RoleDao;
import com.damo.examsys.entity.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleDaoTest {
    @Autowired
    RoleDao roleDao;
    @Test
    public void testFindAllRole(){
        List<Role> allRole = roleDao.findAllRole();
        for (Role role : allRole) {
            System.out.println(role);
        }
    }

    @Test
    public void testDelete(){
        Integer integer = roleDao.deleteUserRoleByUserId(1);
    }
}
