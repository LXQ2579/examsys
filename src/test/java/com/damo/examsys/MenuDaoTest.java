package com.damo.examsys;

import com.damo.examsys.dao.MenuDao;
import com.damo.examsys.entity.Menu;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MenuDaoTest {
    @Autowired
    MenuDao menuDao;

    @Test
    public void testFindMenu(){
       Menu rootMenu = menuDao.getRootMenu(1);
        System.out.println(rootMenu);

    }

}
