package com.damo.examsys.service.impl;

import com.damo.examsys.dao.QuestionsTypeDao;
import com.damo.examsys.entity.QuestionsType;
import com.damo.examsys.service.QuestionsTypeService;
import com.github.pagehelper.PageHelper;
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
    public List<QuestionsType> findAll() {
        return questionsTypeDao.findAll();
    }
}
