package com.damo.examsys.service;

import com.damo.examsys.entity.Paper;
import com.damo.examsys.entity.Questions;
import com.damo.examsys.entity.QuestionsInfo;

import java.util.List;
import java.util.Map;

/**
 * @author liujiulong
 * @date 2019/10/17  11:58:00
 */
public interface PaperService {

    List<Paper> findAll(Map<String, Integer> pageMap, String paperName, Integer subjectId);

    void add(Paper paper);

    Paper findById(Integer paperId);

    void update(Paper paper);

    void deleteById(Integer paperId);

    QuestionsInfo getQuestions(Integer paperId);

}
