package com.damo.examsys.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author liujiulong
 * @date 2019/10/18  08:54:00
 */
@Getter
@Setter
public class QuestionsInfo {

    private List<Questions> choiceQuestions;
    private Integer choiceQuestionsLength;
    private List<Questions> completionQuestions;
    private Integer completionQuestionsLength;
    private List<Questions> shortAnswerQuestions;
    private Integer shortAnswerQuestionsLength;

}
