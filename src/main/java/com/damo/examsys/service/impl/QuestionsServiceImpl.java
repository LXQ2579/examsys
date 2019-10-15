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
//        PageHelper.startPage(page,limit);
        return questionsDao.findAll();
    }

    @Override
    public Questions findById(Integer qId) {
        return questionsDao.findById(qId);
    }

    @Override
    public void update(Questions questions) {
        questionsDao.update(questions);
    }

    @Override
    public void deleteById(Integer qId) {
        questionsDao.deleteById(qId);
    }

    @Override
    public void add(Questions questions) {
        questionsDao.add(questions);
    }
}
