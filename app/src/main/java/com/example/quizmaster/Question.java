package com.example.quizmaster;

import java.io.Serializable;

public class Question implements Serializable {
    private String questionText;
    private String[] options;
    private String correctAnswer;

    // Constructor
    public Question(String questionText, String[] options, String correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    // Getters
    public String getQuestionText() {

        return questionText;
    }

    public String[] getOptions() {

        return options;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
}
