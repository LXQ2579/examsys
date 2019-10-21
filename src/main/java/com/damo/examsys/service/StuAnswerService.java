package com.damo.examsys.service;

import com.damo.examsys.entity.StuAnswer;

import java.util.List;

public interface StuAnswerService {


    List<StuAnswer> getAnswer(Integer stuNum, Integer paperId);
}
