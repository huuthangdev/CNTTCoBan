package com.example.cnttcoban.Controller;

import java.util.Map;

public class Question {
    private Map<String, String> answer;
    private String question;
    private String rightAnswer;

    public Map<String, String> getAnswer() {
        return answer;
    }

    void setAnswer(Map<String, String> answer) {
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    void setQuestion(String question) {
        this.question = question;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    void setRightAnswer(String rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    Question() {

    }
}
