package com.damo.examsys.service;

import com.damo.examsys.common.JsonBean;
import com.damo.examsys.entity.Class;
import com.damo.examsys.entity.Student;

import java.util.List;
import java.util.Map;

/**
 * @author leizhonggang
 */

public interface StudentService {

    public Student findStuByNum(Integer stuNum);

    public JsonBean addStudent(Student student);

    public List<Class> classList();

    public void deleteStudent(Integer stuNum);

    public List<Student> getStudents(Map<String, Integer> pageMap, Integer stuNum, String stuName, Integer classId);

    public void updateStudent(Student student);
}
