package com.damo.examsys.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author sanriyue
 */

public interface UserService {
    Map<String,Object> findAllUser (int pageNum, int pageSize);
}
