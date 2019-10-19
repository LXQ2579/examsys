package com.damo.examsys.service;

import com.damo.examsys.common.JsonBean;
import com.damo.examsys.entity.Role;

import java.util.List;

/**
 * @author sanriyue
 */
public interface RoleService {

    List<Role> findAllRole(Integer isDeleted);

    JsonBean<List<Role>> findAllRolePerm(int pageNum, int pageSize, Integer isDeleted);

    JsonBean<String> updateRole(Role role);

    JsonBean<String> deleteRole(Integer rid, Integer isDeleted);

    JsonBean<String> deleteAllRole(String[] rids, Integer isDeleted);


    public Integer findByRdesc(String rdesc);
}
