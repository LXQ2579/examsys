package com.damo.examsys.service;

import com.damo.examsys.entity.Subject;

import java.util.HashMap;
import java.util.List;

/**
 * @author liujiulong
 * @date 2019/10/15  16:09:00
 */
public interface SubjectService {

    List<Subject> findAllPage(HashMap<String, Integer> pageMap);

    List<Subject> findAll();

    Subject findByName(String subjectName);


    Subject findById(Integer subjectId);

    void update(Subject subject);

    void deleteById(Integer subjectId);

    void add(Subject subject);

}
