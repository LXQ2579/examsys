package com.damo.examsys.service.impl;

import com.damo.examsys.dao.QuestionsDao;
import com.damo.examsys.entity.Questions;
import com.damo.examsys.service.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liujiulong
 * @date 2019/10/14  15:58:00
 */
@Service
public class QuestionsServiceImpl implements QuestionsService {

    @Autowired
    private QuestionsDao questionsDao;

    @Override
    public List<Questions> findAll() {
        return questionsDao.findAll();
    }
}
