package com.damo.examsys.dao;

import com.damo.examsys.entity.Questions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liujiulong
 * @date 2019/10/14  14:45:00
 */
@Repository
public interface QuestionsDao {

    List<Questions> findAll();

}
