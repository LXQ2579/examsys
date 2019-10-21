package com.damo.examsys.service;

import com.damo.examsys.entity.SubExamInfo;
import com.damo.examsys.entity.Subject;

import java.util.List;
import java.util.Map;

public interface SubExamInfoService {

    public List<Subject> findSubNames();

    public List<SubExamInfo> findAllSubInfo(Integer subjectId);

    public List<SubExamInfo> findSubInfo(Map<String, Integer> pageMap, Integer sId);

    public void chooseSubject(Integer listId,Integer stuNum);

}
