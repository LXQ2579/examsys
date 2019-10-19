package com.damo.examsys.dao;

import com.damo.examsys.entity.ExamList;
import com.damo.examsys.entity.Grade;
import com.damo.examsys.entity.Paper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface ExamListDao {

    /**
     * 获取所有考试场次
     * @return
     */
      List<ExamList> getExamList(ExamList examList);

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
     * 获取考试场次
     * @return
     */
    ExamList getExamListById(Integer listId);

    /**
     * 根据条件获取考试场次
     * @return
     */
    List<ExamList> getExamListByCondition(ExamList examList);

    /**
     * 查看教室是否可以成为考场
     * @return
     */
    Integer findExamAddress(ExamList examList);

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


    List<ExamList> hasExamList(@Param(value = "paperName")String paperName, @Param(value = "gradeId") Integer gradeId, @Param(value = "subjectId") Integer subjectId);

    List<ExamList> notExamList(@Param(value = "paperName")String paperName, @Param(value = "gradeId") Integer gradeId, @Param(value = "subjectId") Integer subjectId);


}
