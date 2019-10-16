package com.damo.examsys.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author sanriyue
 */
@Data
public class MenuModule implements Serializable {
    private Integer menuModuleId;
    private String menuModuleName;

    private Menu child;
}
