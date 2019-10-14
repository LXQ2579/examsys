package com.damo.examsys.dao;

import com.damo.examsys.common.JsonBean;
import com.damo.examsys.entity.Student;

import java.util.List;

/**
 * @author leizhonggang
 */

public interface StudentDao {

    /**
     * 通过stuNum获得stu对象，得到学生个人资料,学生调用
     * @param stuNum
     * @return
     */
    public Student findStuByNum(Integer stuNum);

    /**
     * 添加学生信息
     */
    public JsonBean addStudent();

    /**
     * 修改学生信息
     */
    public JsonBean updateStudent(Integer stuNum);

    /**
     * 删除
     * @param stuNum
     */
    public JsonBean deleteStudent(Integer stuNum);

    /**
     * 教师得到所有考生信息列表调用此方法
     * @return
     */
    public List<Student> getStudents();

    /**
     * 通过科目id来查询考生信息
     * @param subjectId
     * @return
     */
    public List<Student> getStudentsBySubjectId(Integer subjectId);

}
