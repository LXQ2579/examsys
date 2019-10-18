package com.damo.examsys.dao;

import com.damo.examsys.entity.Paper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liujiulong
 * @date 2019/10/17  11:53:00
 */
@Repository
public interface PaperDao {

    List<Paper> findAll(@Param(value = "paperName")String paperName, @Param("subjectId")Integer subjectId);

    void add(Paper paper);

    Paper findById(Integer paperId);

    void update(Paper paper);

    void deleteById(Integer paperId);
}
