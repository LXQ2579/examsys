package com.damo.examsys.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

/**
 * @author sanriyue
 */

public interface UserService {
    PageInfo findAllUser (int pageNum, int pageSize);
}
