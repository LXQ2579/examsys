package com.damo.examsys.service.impl;

import com.damo.examsys.dao.QuestionsTypeDao;
import com.damo.examsys.entity.QuesType;
import com.damo.examsys.service.QuestionsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liujiulong
 * @date 2019/10/15  08:37:00
 */
@Service
public class QuestionsTypeServiceImpl implements QuestionsTypeService {

    @Autowired
    private QuestionsTypeDao questionsTypeDao;

    @Override
    public List<QuesType> findAll() {
        return questionsTypeDao.findAll();
    }

    @Override
    public QuesType findByName(String quesTypeName) {
        return questionsTypeDao.findByName(quesTypeName);
    }


}
