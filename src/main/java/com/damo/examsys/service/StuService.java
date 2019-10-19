package com.damo.examsys.service;

import com.damo.examsys.entity.Class;
import com.damo.examsys.entity.Student;

public interface StuService {
    //注册stu
    public void addStu(Student stu);
    //查询班级信息
    public Class findByClassName(String className);
}
