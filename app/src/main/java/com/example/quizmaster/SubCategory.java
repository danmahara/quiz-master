package com.example.quizmaster;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SubCategory implements Serializable {
    private String name;
    private List<Question> questions;

    public SubCategory(String name) {
        this.name = name;
        this.questions = new ArrayList<>();
    }

    public String getSubCategoryName() {
        return name;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }
}
