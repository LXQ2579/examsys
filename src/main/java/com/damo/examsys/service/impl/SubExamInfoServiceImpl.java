package com.damo.examsys.service.impl;

import com.damo.examsys.dao.SubExamInfoDao;
import com.damo.examsys.entity.SubExamInfo;
import com.damo.examsys.entity.Subject;
import com.damo.examsys.service.SubExamInfoService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SubExamInfoServiceImpl implements SubExamInfoService {
    @Autowired(required = false)
    SubExamInfoDao subExamInfoDao;

    @Override
    public List<Subject> findSubNames() {
        List<Subject> subNames = subExamInfoDao.findSubNames();
        return subNames;
    }

    @Override
    public List<SubExamInfo> findAllSubInfo(Integer subjectId) {
        List<SubExamInfo> allSubInfo = subExamInfoDao.findAllSubInfo(subjectId);
        return allSubInfo;
    }

    @Override
    public List<SubExamInfo> findSubInfo(Map<String, Integer> pageMap, Integer sId) {
        PageHelper.startPage(pageMap.get("page"), pageMap.get("limit"));
        List<SubExamInfo> subInfo = subExamInfoDao.findSubInfo(sId);
        return subInfo;
    }

    @Override
    public void chooseSubject(Integer listId, Integer stuNum) {
        subExamInfoDao.chooseSubject(listId,stuNum);
    }
}
