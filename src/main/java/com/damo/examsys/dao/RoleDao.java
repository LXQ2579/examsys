package com.damo.examsys.dao;

import com.damo.examsys.entity.Role;

import java.util.List;
import java.util.Map;

/**
 * @author sanriyue
 */
public interface RoleDao {
    List<Role> findAllRole();

    Integer updateUserRole(List<Map<String, Object>> list);

    Integer deleteUserRoleByUserId(Integer uid);
}
