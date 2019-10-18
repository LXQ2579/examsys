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
}
