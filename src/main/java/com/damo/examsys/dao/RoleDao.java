package com.damo.examsys.dao;

import com.damo.examsys.entity.Permission;
import com.damo.examsys.entity.Role;

import java.util.List;
import java.util.Map;

/**
 * @author sanriyue
 */
public interface RoleDao {
    /**
     * 仅仅获取角色的列表
     * @param isDeleted 是否查询删除的结果集 0为正常，1 为删除
     * @return 角色的列表
     */
    List<Role> findAllRole(Integer isDeleted);

    /**
     * 获取角色以及对应权限的结果集
     * @param isDeleted 是否查询删除的结果集 0为正常，1 为删除
     * @return 角色的列表
     */
    List<Role> findAllRolePerm(Integer isDeleted);

    List<Permission> getPermissionList(Integer rid);

    List<Permission> findPermChildByParentId(Integer pid);

    Integer updateUserRole(List<Map<String, Integer>> list);

    Integer deleteUserRoleByUserId(Integer uid);
}
