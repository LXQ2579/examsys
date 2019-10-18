package com.damo.examsys;

import com.damo.examsys.dao.RoleDao;
import com.damo.examsys.entity.Permission;
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
        List<Role> allRole = roleDao.findAllRole(0);
        for (Role role : allRole) {
            System.out.println(role);
        }
    }

    @Test
    public void testDelete(){
        Integer integer = roleDao.deleteUserRoleByUserId(1);
    }

    @Test
    public void testFindAllRolePerm(){
        List<Role> allRole = roleDao.findAllRolePerm(0);
        for (Role role : allRole) {
            System.out.println(role);
        }
    }

    @Test
    public void testFindPerm(){
        List<Permission> permissionList = roleDao.getPermissionList(1);
        for (Permission permission : permissionList) {
            System.out.println(permission);
        }
        List<Permission> permChildByParentId = roleDao.findPermChildByParentId(1);
        for (Permission permission : permChildByParentId) {
            System.out.println(permission);
        }
    }
}
