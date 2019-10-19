package com.damo.examsys.dao;

import com.damo.examsys.entity.ScoreManage;

import java.util.HashMap;
import java.util.List;

public interface ScoreManageDao {

      /**
       * 查找所有考生的试卷信息
       * @return
       */
      List<ScoreManage> findAllExamScore(HashMap<String, Object> condition);


      /**
       *
       * @param condition
       * @return
       */
      Integer findDataCount(HashMap<String, Object> condition);
}
