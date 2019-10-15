package com.damo.examsys.service.impl;

import com.damo.examsys.dao.StudentDao;
import com.damo.examsys.entity.Student;
import com.damo.examsys.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
