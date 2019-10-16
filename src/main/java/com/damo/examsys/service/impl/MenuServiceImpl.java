package com.damo.examsys.service.impl;

import com.alibaba.fastjson.JSON;
import com.damo.examsys.common.CodeMsg;
import com.damo.examsys.common.ErrorCode;
import com.damo.examsys.dao.MenuDao;
import com.damo.examsys.entity.Menu;
import com.damo.examsys.entity.MenuModule;
import com.damo.examsys.exception.MyException;
import com.damo.examsys.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @author sanriyue
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    MenuDao menuDao;
    @Autowired
    CodeMsg codeMsg;
    @Override
    public Menu getMenu(Integer menuId) {
        if (menuId == null){
            throw new MyException(ErrorCode.MENUID_NULL,codeMsg.getMenuIdNull());
        }
        Menu menu = menuDao.getMenu(menuId);
        if (menu == null){
            throw new MyException(ErrorCode.MENU_NULL,codeMsg.getMenuNull());
        }
        return menu;
    }


    @Override
    public String getRootMenu() {
        List<MenuModule> rootMenu = menuDao.getRootMenu();

        if (rootMenu ==null){
            throw  new RuntimeException("根目录查询有误，请联系管理员");
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        for (MenuModule menu : rootMenu) {
            hashMap.put(menu.getMenuModuleName(),menu.getChild());
        }
        String s = JSON.toJSONString(hashMap);
        String s1 = s.replace("\"child\":[],", "");
        return s1;
    }
}
