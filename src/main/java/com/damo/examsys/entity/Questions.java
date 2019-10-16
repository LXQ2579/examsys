package com.damo.examsys.entity;


import java.io.Serializable;


/**
 * @author liujiulong
 * @date 2019/10/14  14:45:00
 */
public class Questions implements Serializable {

    private Integer qId;
    private String title;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String standardAnswer;
    private String answerDetail;
    private Integer subjectId;
    private String subjectName;
    private Subject subject;
    //类型编号: 0 为 选择题, 1 为 判断题, 2 为简答题
    private Integer typeId;
    private String quesTypeName;
    private QuesType quesType;
    private String remark;
    private Integer score;


    public String getQuesTypeName() {
        return quesTypeName;
    }

    public void setQuesTypeName(String quesTypeName) {
        this.quesTypeName = quesTypeName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Integer getqId() {
        return qId;
    }

    public void setqId(Integer qId) {
        this.qId = qId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    public String getStandardAnswer() {
        return standardAnswer;
    }

    public void setStandardAnswer(String standardAnswer) {
        this.standardAnswer = standardAnswer;
    }

    public String getAnswerDetail() {
        return answerDetail;
    }

    public void setAnswerDetail(String answerDetail) {
        this.answerDetail = answerDetail;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public QuesType getQuesType() {
        return quesType;
    }

    public void setQuesType(QuesType quesType) {
        this.quesType = quesType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Questions{" +
                "qId=" + qId +
                ", title='" + title + '\'' +
                ", optionA='" + optionA + '\'' +
                ", optionB='" + optionB + '\'' +
                ", optionC='" + optionC + '\'' +
                ", optionD='" + optionD + '\'' +
                ", standardAnswer='" + standardAnswer + '\'' +
                ", answerDetail='" + answerDetail + '\'' +
                ", subjectId=" + subjectId +
                ", subjectName='" + subjectName + '\'' +
                ", subject=" + subject +
                ", typeId=" + typeId +
                ", quesTypeName='" + quesTypeName + '\'' +
                ", quesType=" + quesType +
                ", remark='" + remark + '\'' +
                ", score=" + score +
                '}';
    }
}
