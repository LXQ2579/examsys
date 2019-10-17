package com.damo.examsys.service.impl;

import com.damo.examsys.dao.RoleDao;
import com.damo.examsys.entity.Role;
import com.damo.examsys.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sanriyue
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleDao roleDao;


    @Override
    public List<Role> findAllRole() {
        List<Role> allRole = roleDao.findAllRole();
        if (allRole == null){

            throw new RuntimeException("角色获取异常");
        }
        return allRole;
    }
}
