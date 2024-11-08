package com.example.quizmaster;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;


public class Category implements Serializable {

    private String name;
    private List<SubCategory> subcategories;

    public Category(String name) {
        this.name = name;
        this.subcategories = new ArrayList<>();
    }

    public String getCategoryName() {
        return name;
    }


    public List<SubCategory> getSubcategories() {
        return subcategories;
    }

    public void addSubcategory(SubCategory subcategory) {
        subcategories.add(subcategory);
    }


}