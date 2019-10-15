package com.damo.examsys.service;

import com.damo.examsys.entity.ExamList;

import java.util.List;

public interface ExamListService {

    /**
     * 获取所有考试场次
     * @return
     */
    List<ExamList> getExamList();

    /**
     * 添加考试场次信息
     * @param examList
     */
    void addExam(ExamList examList);

    /**
     * 修改考试场次信息
     * @param examList
     */
    void updateExam(ExamList examList);

    /**
     * 根据id删除考试场次
     * @param listId
     */
    void delExam(Integer listId);

    /**
     * 根据id查询单个考试场次信息
     * @param listId
     * @return
     */
    ExamList getExamListById(Integer listId);


}
