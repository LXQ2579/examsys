package com.damo.examsys.service.impl;

import com.damo.examsys.dao.QuesTypeDao;
import com.damo.examsys.entity.QuesType;
import com.damo.examsys.service.QuesTypeService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @author liujiulong
 * @date 2019/10/15  08:37:00
 */
@Service
public class QuesTypeServiceImpl implements QuesTypeService {

    @Autowired
    private QuesTypeDao quesTypeDao;

    @Override
    public List<QuesType> findAllPage(HashMap<String, Integer> pageMap) {
        PageHelper.startPage(pageMap.get("page"), pageMap.get("limit"));
        return quesTypeDao.findAll();
    }

    @Override
    public List<QuesType> findAll() {
        return quesTypeDao.findAll();
    }

    @Override
    public QuesType findByName(String quesTypeName) {
        return quesTypeDao.findByName(quesTypeName);
    }

    @Override
    public QuesType findById(Integer quesTypeId) {
        return quesTypeDao.findById(quesTypeId);
    }

    @Override
    public void update(QuesType quesType) {
        quesTypeDao.update(quesType);
    }

    @Override
    public void deleteById(Integer quesTypeId) {
        quesTypeDao.deleteById(quesTypeId);
    }

    @Override
    public void add(QuesType quesType) {
        quesTypeDao.add(quesType);
    }


}
