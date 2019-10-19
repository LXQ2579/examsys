package com.damo.examsys.dao;

import com.damo.examsys.entity.Permission;
import com.damo.examsys.entity.Role;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author sanriyue
 */
@Repository
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

    Integer updateRole(Role role);

    Integer deleteRole(Integer rid ,Integer isDeleted);

    Integer deleteAllRole(String[] rid ,Integer isDeleted);


    //通过角色名查询rid
    public Integer findRid(String rdesc);

}
