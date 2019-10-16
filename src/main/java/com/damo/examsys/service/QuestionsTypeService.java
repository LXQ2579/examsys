package com.damo.examsys.service;

import com.damo.examsys.entity.QuesType;

import java.util.List;

/**
 * @author liujiulong
 * @date 2019/10/15  08:37:00
 */
public interface QuestionsTypeService {

    List<QuesType> findAll();


    QuesType findByName(String quesTypeName);

}
