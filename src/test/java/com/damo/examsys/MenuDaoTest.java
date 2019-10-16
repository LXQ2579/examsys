package com.damo.examsys;

import com.alibaba.fastjson.JSON;
import com.damo.examsys.common.IndexInit;
import com.damo.examsys.common.InitMsg;
import com.damo.examsys.dao.MenuDao;
import com.damo.examsys.entity.Menu;
import com.damo.examsys.entity.MenuModule;
import com.damo.examsys.utils.IndexInitUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MenuDaoTest {
    @Autowired
    MenuDao menuDao;
    @Autowired
    IndexInit indexInit;
    @Autowired
    InitMsg initMsg;
    @Autowired
    IndexInitUtils indexInitUtils;

    @Test
    public void testFindMenu(){
        List<MenuModule> rootMenu = menuDao.getRootMenu();
        HashMap<String, Object> hashMap = new HashMap<>();
        for (MenuModule menu : rootMenu) {
            hashMap.put(menu.getMenuModuleName(),menu.getChild());
        }

        String s = JSON.toJSONString(hashMap);
        String s1 = s.replace("\"child\":[],", "");
        System.out.println(s1);

    }

    @Test
    public void testAddString(){
        String clear = IndexInit.CLEAR_INFO_1 + initMsg.getClearUrl() +IndexInit. CLEAR_INFO_2;
        String home = IndexInit.HOME_INFO_TITLE + initMsg.getHomeInfoTitle() +
                IndexInit. HOME_INFO_ICON + initMsg.getHomeInfoIcon()+
                IndexInit. HOME_INFO_HREF + initMsg.getHomeInfoHref() +
                IndexInit.HOME_INFO_END ;
        String logo = IndexInit.LOGO_INFO_TITLE + initMsg.getLogoInfoTitle() +
                IndexInit.LOGO_INFO_IMAGE + initMsg.getLogoInfoImage() +
                IndexInit.LOGO_INFO_HREF + initMsg.getLogoInfoHref() + IndexInit.LOGO_INFO_END;
        List<MenuModule> rootMenu = menuDao.getRootMenu();
        HashMap<String, Object> hashMap = new HashMap<>();
        for (MenuModule menu : rootMenu) {
            hashMap.put(menu.getMenuModuleName(),menu.getChild());
        }

        String s = JSON.toJSONString(hashMap);
        String s1 = s.replace("\"child\":[],", "");
        System.out.println(s1);


        String s2 = indexInitUtils.indexInit(s1);
        System.out.println(s2);
    }

}
