package com.damo.examsys.dao;

import com.damo.examsys.entity.Questions;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author liujiulong
 * @date 2019/10/14  14:45:00
 */
@Repository
public interface QuestionsDao {

    List<Questions> findAll(@Param(value = "questionName") String questionName, @Param(value = "typeId") Integer typeId
            , @Param(value = "subjectId") Integer subjectId);

    Questions findById(Integer qId);

    void update(Questions questions);

    void deleteById(Integer qId);

    void add(Questions questions);

    void batchInsert(List<Questions> questionsList);

}
