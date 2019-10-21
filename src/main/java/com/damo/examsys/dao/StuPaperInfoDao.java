package com.damo.examsys.dao;

import com.damo.examsys.entity.StuPaperInfo;
import org.apache.ibatis.annotations.Param;

public interface StuPaperInfoDao {

    StuPaperInfo getStuPaperInfo(@Param("stuNum") Integer stuNum, @Param("listId") Integer listId);
}
