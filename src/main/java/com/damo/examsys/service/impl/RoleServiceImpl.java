package com.damo.examsys.service.impl;

import com.damo.examsys.common.JsonBean;
import com.damo.examsys.dao.RoleDao;
import com.damo.examsys.entity.Role;
import com.damo.examsys.service.RoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

    @Override
    public JsonBean<String> updateRole(Role role) {
        Integer integer = roleDao.updateRole(role);
        if (integer<1){
            throw new RuntimeException("角色更新异常");
        }
        return new JsonBean<>(0,"角色更新成功");
    }

    @Override
    public JsonBean<String> deleteRole(Integer rid, Integer isDeleted) {
        Integer integer = roleDao.deleteRole(rid, isDeleted);
        if (integer < 1){
            throw  new RuntimeException("角色状态更新异常");
        }
        return new JsonBean<>(0,"角色状态更新成功");
    }

    @Override
    public JsonBean<String> deleteAllRole(String[] rids, Integer isDeleted) {
        Integer integer = roleDao.deleteAllRole(rids, isDeleted);
        if (integer < 1){
            throw  new RuntimeException("批量删除角色异常");
        }
         return new JsonBean<>(0,"批量删除角色异常");
    }
}
