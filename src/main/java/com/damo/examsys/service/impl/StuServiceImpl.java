package com.damo.examsys.service.impl;

import com.damo.examsys.dao.StuDao;
import com.damo.examsys.entity.Class;
import com.damo.examsys.entity.Student;
import com.damo.examsys.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StuServiceImpl implements StuService {
    @Autowired
    private StuDao stuDao;

    @Override
    public void addStu(Student stu) {

        stuDao.addStu(stu.getStuNum(),stu.getStuPwd(),stu.getStuName(),stu.getStuGender(),stu.getStuIdnum(),stu.getClassId());
    }

    @Override
    public Class findByClassName(String className) {

        return stuDao.findByClassName(className);
    }
}
