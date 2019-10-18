package com.damo.examsys.service.impl;

import com.damo.examsys.common.JsonBean;
import com.damo.examsys.dao.RoleDao;
import com.damo.examsys.entity.Role;
import com.damo.examsys.service.RoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sanriyue
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleDao roleDao;


    @Override
    public List<Role> findAllRole(Integer isDeleted) {
        List<Role> allRole = roleDao.findAllRole(isDeleted);
        if (allRole == null){

            throw new RuntimeException("角色获取异常");
        }
        return allRole;
    }

    @Override
    public JsonBean<List<Role>> findAllRolePerm(int pageNum, int pageSize,Integer isDeleted) {
        PageHelper.startPage(pageNum,pageSize);
        List<Role> allRolePerm = roleDao.findAllRolePerm(isDeleted);
        if (allRolePerm == null){
            throw new RuntimeException("角色获取异常");
        }
        PageInfo<Role> rolePageInfo = new PageInfo<>(allRolePerm);
        return new JsonBean<>(0, rolePageInfo.getList(),"",Integer.valueOf(rolePageInfo.getTotal()+""));
    }
}
