package com.damo.examsys.service.impl;

import com.damo.examsys.dao.SubjectDao;
import com.damo.examsys.entity.Subject;
import com.damo.examsys.service.SubjectService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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
    public List<Subject> findAllPage(HashMap<String, Integer> pageMap) {
        PageHelper.startPage(pageMap.get("page"), pageMap.get("limit"));
        return subjectDao.findAll();
    }

    @Override
    public List<Subject> findAll() {
        return subjectDao.findAll();
    }

    @Override
    public Subject findByName(String subjectName) {
        return subjectDao.findByName(subjectName);
    }

    @Override
    public Subject findById(Integer subjectId) {
        return subjectDao.findById(subjectId);
    }

    @Override
    public void update(Subject subject) {
        subjectDao.update(subject);
    }

    @Override
    public void deleteById(Integer subjectId) {
        subjectDao.deleteById(subjectId);
    }

    @Override
    public void add(Subject subject) {
        subjectDao.add(subject);
    }
}
