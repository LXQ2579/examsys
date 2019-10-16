package com.damo.examsys.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author leizhonggang
 */

@Data
public class StuInfo implements Serializable {

    private Date beginTime;
    private Date endTime;
    private String examAddress;
    private String className;
    private String sName;

}
