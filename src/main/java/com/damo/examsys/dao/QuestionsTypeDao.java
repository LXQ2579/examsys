package com.damo.examsys.dao;

import com.damo.examsys.entity.QuesType;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liujiulong
 * @date 2019/10/15  08:35:00
 */
@Repository
public interface QuestionsTypeDao {

    List<QuesType> findAll();

    QuesType findByName(String quesTypeName);

}
