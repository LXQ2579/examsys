package com.damo.examsys.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author sanriyue
 */
@Data
public class Permission implements Serializable {
    private Integer pid;
    private String pname;
    private String pdesc;
    private String type;
    private String url;
    private Integer parentId;
    private List<Permission> permChild;
}
