package com.damo.examsys.service;

import com.damo.examsys.common.JsonBean;
import com.damo.examsys.entity.Class;
import com.damo.examsys.entity.Student;

import java.util.List;

/**
 * @author leizhonggang
 */

public interface StudentService {

    public Student findStuByNum(Integer stuNum);

    public JsonBean addStudent(Student student);

    public List<Class> classList();

    public JsonBean deleteStudent(Integer stuNum);
}
