package com.damo.examsys.service;

import com.damo.examsys.entity.ExamList;
import com.damo.examsys.entity.Grade;
import com.damo.examsys.entity.Paper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ExamListService {

    /**
     * 获取所有考试场次
     * @return
     */
    List<ExamList> getExamList(ExamList examList);

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

    /**
     * 获取所有年级信息
     * @return
     */
    List<Grade> getGradeList();

    /**
     * 获取所有试卷
     * @return
     */
    List<Paper> getPaperList();

    /**
     * 获取数据总数
     * @return
     */
    Integer dataCount(ExamList examList);


    List<ExamList> hasExamList(Map<String, Integer> pageMap, String paperName, Integer gradeId, Integer subjectId);

    List<ExamList> notExamList(Map<String, Integer> pageMap, String paperName, Integer gradeId,  Integer subjectId);



}
