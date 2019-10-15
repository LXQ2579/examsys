package com.damo.examsys.dao;

import com.damo.examsys.entity.ExamList;
import io.swagger.models.auth.In;

import java.util.List;

public interface ExamListDao {

    /**
     * 获取所有考试场次
     * @return
     */
      List<ExamList> getExamList();

    /**
     * 添加考试场次信息
     * @param examList
     * @return
     */
      int addExam(ExamList examList);

    /**
     * 修改考试场次信息
     * @param examList
     * @return
     */
    int updateExam(ExamList examList);

    /**
     * 根据id删除考试场次
     * @param listId
     * @return
     */
    int delExam(Integer listId);

    /**
     * 获取所有考试场次
     * @return
     */
    ExamList getExamListById(Integer listId);


}
