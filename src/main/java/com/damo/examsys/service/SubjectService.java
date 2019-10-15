package com.damo.examsys.service;

import com.damo.examsys.entity.QuestionsType;
import com.damo.examsys.entity.Subject;

import java.util.List;

/**
 * @author liujiulong
 * @date 2019/10/15  16:09:00
 */
public interface SubjectService {

    List<Subject> findAll();

}
