package com.damo.examsys.dao;

import com.damo.examsys.entity.StuAnswer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StuAnswerDao {

    List<StuAnswer> getAnswer(@Param("stuNum") Integer stuNum, @Param("paperId")Integer paperId);
}
