package com.damo.examsys.service.impl;

import com.damo.examsys.dao.ClassDao;
import com.damo.examsys.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {
    @Autowired
    private ClassDao classDao;
    @Override
    public List<String> findAllClass() {
        classDao.findAllClass();
        return classDao.findAllClass();
    }
}
