package com.damo.examsys.dao;

import com.damo.examsys.entity.Class;
import org.springframework.stereotype.Repository;

@Repository
public interface StuDao {
    //学生注册
   public void addStu(Integer stuNum, String stuPwd, String stuName, String stuGender, String stuIdNum, Integer classId);
    //查询班级id
    public Class findByClassName(String className);

}
