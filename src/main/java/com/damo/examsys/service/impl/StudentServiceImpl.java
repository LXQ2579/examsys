package com.damo.examsys.service.impl;

import com.damo.examsys.common.JsonBean;
import com.damo.examsys.dao.StudentDao;
import com.damo.examsys.entity.Class;
import com.damo.examsys.entity.Student;
import com.damo.examsys.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author leizhonggang
 */

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired(required = false)
    private StudentDao studentDao;

    @Override
    public Student findStuByNum(Integer stuNum) {

        return studentDao.findStuByNum(stuNum);
    }

    @Override
    public JsonBean addStudent(Student student) {
        studentDao.addStudent(student);
        JsonBean jsonBean = new JsonBean();
        jsonBean.setCode(0);
        jsonBean.setData("添加成功");
        return jsonBean;
    }

    @Override
    public List<Class> classList() {
        return studentDao.classList();
    }

    @Override
    public JsonBean deleteStudent(Integer stuNum) {
        JsonBean jsonBean = studentDao.deleteStudent(stuNum);
        jsonBean.setCode(0);
        jsonBean.setData("删除成功");
        return jsonBean;
    }
}
