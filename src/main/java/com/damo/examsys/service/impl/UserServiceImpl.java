package com.damo.examsys.service.impl;

import com.damo.examsys.dao.UserDao;
import com.damo.examsys.entity.User;
import com.damo.examsys.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Override
    public Map<String,Object> findAllUser(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        Page<User> allUser = userDao.findAllUser();
        if (allUser.get(0) == null){
            throw new RuntimeException("数据查询异常");
        }
        PageInfo<User> userPageInfo = new PageInfo<>(allUser);
        Map<String,Object> tableData =new HashMap<String,Object>();
        //这是layui要求返回的json数据格式
        tableData.put("code",0);
        tableData.put("msg", "");
        //将全部数据的条数作为count传给前台（一共多少条）
        tableData.put("count", userPageInfo.getTotal());
        //将分页后的数据返回（每页要显示的数据）
        tableData.put("data", userPageInfo.getList());
        return tableData;
    }
}
