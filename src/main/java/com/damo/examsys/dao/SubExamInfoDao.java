package com.damo.examsys.dao;

import com.damo.examsys.entity.SubExamInfo;
import com.damo.examsys.entity.Subject;

import java.util.List;

public interface SubExamInfoDao {

    public List<Subject> findSubNames();

    public List<SubExamInfo> findAllSubInfo(Integer subjectId);

    public List<SubExamInfo> findSubInfo(Integer sId);

    public void chooseSubject(Integer listId,Integer stuNum);

}
