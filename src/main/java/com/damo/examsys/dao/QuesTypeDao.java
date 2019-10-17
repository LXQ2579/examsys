package com.damo.examsys.dao;

import com.damo.examsys.entity.QuesType;
import com.damo.examsys.entity.Questions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liujiulong
 * @date 2019/10/15  08:35:00
 */
@Repository
public interface QuesTypeDao {

    List<QuesType> findAll();

    QuesType findByName(String quesTypeName);

    QuesType findById(Integer quesTypeId);

    void update(QuesType quesType);

    void deleteById(Integer quesTypeId);

    void add(QuesType quesType);

}
