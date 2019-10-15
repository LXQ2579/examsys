package com.damo.examsys.service.impl;

import com.damo.examsys.dao.SubjectDao;
import com.damo.examsys.entity.QuestionsType;
import com.damo.examsys.entity.Subject;
import com.damo.examsys.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liujiulong
 * @date 2019/10/15  16:09:00
 */
@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectDao subjectDao;

    @Override
    public List<Subject> findAll() {
        return subjectDao.findAll();
    }
}
