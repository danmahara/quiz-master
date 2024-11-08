package com.example.quizmaster;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NavUtils;

import java.util.List;

//public class QuestionListActivity extends AppCompatActivity {
//
//    private ListView questionListView;
//    private List<Question> questionList;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_question_list);
//
//
//        // Set up Toolbar as ActionBar
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        // Enable Up button
//        if (getSupportActionBar() != null) {
//            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        }
//
//
//        // Initialize ListView
//        ListView questionListView = findViewById(R.id.questionListView);
//
//        // Check if ListView is correctly initialized
//        if (questionListView == null) {
//            Toast.makeText(this, "ListView is not found!", Toast.LENGTH_SHORT).show();
//            return;
//        }
//
//        // Get the category object from the Intent
//        Category selectedCategory = (Category) getIntent().getSerializableExtra("SUBCATEGORY");
//
//        if (selectedCategory != null) {
//            // Set the title of the category
//            TextView textView = findViewById(R.id.categoryTitle);
//            textView.setText(selectedCategory.getCategoryName());
//
//            // Retrieve the question list from the selected category
//            questionList = selectedCategory.getQuestions();
//
//            // Create the adapter and set it
//            QuestionAdapter questionAdapter = new QuestionAdapter(this, questionList);
//            questionListView.setAdapter(questionAdapter);
//        } else {
//            Toast.makeText(this, "Category data not found!", Toast.LENGTH_SHORT).show();
//        }
//
//
//        // Inside QuestionListActivity, in onCreate() method
//        questionListView.setOnItemClickListener((parent, view, position, id) -> {
//            // Get the selected question
//            Question selectedQuestion = questionList.get(position);
//
//            // Create an Intent to open OptionListActivity
//            Intent intent = new Intent(this, OptionListActivity.class);
//
//            // Pass the question data (question text and options) to OptionListActivity
//            intent.putExtra("QUESTION_TEXT", selectedQuestion.getQuestionText());
//            intent.putExtra("OPTIONS", selectedQuestion.getOptions());
//            intent.putExtra("CORRECT_ANSWER", selectedQuestion.getCorrectAnswer());
//
//
//            // Start OptionListActivity
//            startActivity(intent);
//        });
//
//    }
//}

public class QuestionListActivity extends AppCompatActivity {

    private SubCategory selectedSubCategory;

    private List<Question> questionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_list);

        // Initialize ListView
        ListView questionListView = findViewById(R.id.questionListView);

        // Get the SubCategory object from the Intent
        selectedSubCategory = (SubCategory) getIntent().getSerializableExtra("SUBCATEGORY");

        // Set the title of the category
        TextView textView = findViewById(R.id.categoryTitle);
        textView.setText(selectedSubCategory.getSubCategoryName());

        // Retrieve the question list from the selected category
        questionList = selectedSubCategory.getQuestions();

        // Create the adapter and set it
        QuestionAdapter questionAdapter = new QuestionAdapter(this, questionList);
        questionListView.setAdapter(questionAdapter);


        // Inside QuestionListActivity, in onCreate() method
        questionListView.setOnItemClickListener((parent, view, position, id) -> {
            // Get the selected question
            Question selectedQuestion = questionList.get(position);

            // Create an Intent to open OptionListActivity
            Intent intent = new Intent(this, OptionListActivity.class);

            // Pass the question data (question text and options) to OptionListActivity
            intent.putExtra("QUESTION_TEXT", selectedQuestion.getQuestionText());
            intent.putExtra("OPTIONS", selectedQuestion.getOptions());
            intent.putExtra("CORRECT_ANSWER", selectedQuestion.getCorrectAnswer());

            // Start OptionListActivity
            startActivity(intent);
        });
    }


}

