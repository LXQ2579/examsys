package com.damo.examsys.service.impl;

import com.damo.examsys.dao.SubjectDao;
import com.damo.examsys.entity.Subject;
import com.damo.examsys.service.SubjectService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @author liujiulong
 * @date 2019/10/15  16:09:00
 */
@Service
@CacheConfig(cacheNames = "subject")
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectDao subjectDao;

    @Override
    public List<Subject> findAllPage(HashMap<String, Integer> pageMap) {
        PageHelper.startPage(pageMap.get("page"), pageMap.get("limit"));
        return subjectDao.findAll();
    }

    @Override
    @Cacheable(key = "'list:all'")
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
    @CacheEvict(key = "'list:all'")
    public void update(Subject subject) {
        subjectDao.update(subject);
    }

    @Override
    @CacheEvict(key = "'list:all'")
    public void deleteById(Integer subjectId) {
        subjectDao.deleteById(subjectId);
    }

    @Override
    @CacheEvict(key = "'list:all'")
    public void add(Subject subject) {
        subjectDao.add(subject);
    }
}
