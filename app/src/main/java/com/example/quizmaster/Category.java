package com.example.quizmaster;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;


public class Category implements Serializable {
    private String categoryName;
    private List<Question> questions;

    // Constructor
    public Category(String categoryName) {
        this.categoryName = categoryName;
        this.questions = new ArrayList<>();
    }

    // Getter for category name
    public String getCategoryName() {

        return categoryName;
    }

    // Getter for questions
    public List<Question> getQuestions() {

        return questions;
    }

    // Method to add a question to the category
    public void addQuestion(Question question) {
        questions.add(question);
    }
}
