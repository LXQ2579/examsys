package com.damo.examsys.dao;

import com.damo.examsys.entity.ExamList;

import java.util.List;

public interface ExamListDao {

    /**
     * 获取所有考试场次
     * @return
     */
      List<ExamList> getExamList();


}
