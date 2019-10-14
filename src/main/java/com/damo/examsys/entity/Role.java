package com.damo.examsys.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author sanriyue
 */
@Data
public class Role implements Serializable {
    private Integer rid;
    private String rname;
    private String rdesc;
    private List<Permission> permissionList;
}
