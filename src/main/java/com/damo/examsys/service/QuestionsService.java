package com.damo.examsys.service;

import com.damo.examsys.entity.Questions;

import java.util.List;

/**
 * @author liujiulong
 * @date 2019/10/14  15:58:00
 */
public interface QuestionsService {

    List<Questions> findAll();

}
