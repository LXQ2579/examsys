package com.damo.examsys;

import com.damo.examsys.common.JsonBean;
import com.damo.examsys.controller.SubExamInfoController;
import com.damo.examsys.entity.SubExamInfo;
import com.damo.examsys.entity.Subject;
import com.damo.examsys.service.SubExamInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SubExamInfoTest {
    @Autowired
    SubExamInfoService subExamInfoService;
    @Autowired
    SubExamInfoController subExamInfoController;

    @Test
    public void testFindSubNames(){
        List<Subject> subNames = subExamInfoService.findSubNames();
        for (Subject s : subNames) {
            System.out.println(s.getsId());
            System.out.println(s.getsName());
        }

    }

    @Test
    public void testFindSubInfo(){
        List<SubExamInfo> allSubInfo = subExamInfoService.findAllSubInfo(1);
        for (SubExamInfo s : allSubInfo) {
            System.out.println(s);
        }

    }


    @Test
    public void testFindInfo(){
//        List<SubExamInfo> allSubInfo = subExamInfoService.findSubInfo();
//        for (SubExamInfo s : allSubInfo) {
//            System.out.println(s);
//        }

    }
    @Test
    public void chooseSub(){
        JsonBean jsonBean = subExamInfoController.chooseSubject(1, 1025);
        System.out.println(jsonBean.getData());

    }




}
