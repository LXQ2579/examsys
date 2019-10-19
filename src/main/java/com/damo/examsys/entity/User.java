package com.damo.examsys.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author sanriyue
 */
@Data
public class User implements Serializable {
    private Integer uid;
    private String uname;
    private String password;
    private List<Role> roleList;
    private UserInfo userInfo;

    private Integer isDeleted;
    private Role role;
}
