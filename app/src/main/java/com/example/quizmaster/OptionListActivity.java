package com.example.quizmaster;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NavUtils;

import com.google.android.material.snackbar.Snackbar;

public class OptionListActivity extends AppCompatActivity {


    private String correctAnswer; // Store the correct answer

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_list);


        // Enabling the back arrow in the toolbar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        // Set the question text
        TextView questionTextView = findViewById(R.id.questionTextView);

        // Retrieve the question text, options, and correct answer from the Intent
        String questionText = getIntent().getStringExtra("QUESTION_TEXT");
        String[] options = getIntent().getStringArrayExtra("OPTIONS");
        correctAnswer = getIntent().getStringExtra("CORRECT_ANSWER");


        questionTextView.setText(questionText);

        // Display options in a ListView
        ListView optionsListView = findViewById(R.id.optionsListView);
        OptionAdapter optionAdapter = new OptionAdapter(this, options);
        optionsListView.setAdapter(optionAdapter);

        optionsListView.setOnItemClickListener((parent, view, position, id) -> {
            // Get the selected option
            String selectedOption = options[position];

            // Reset background color for all items
            for (int i = 0; i < parent.getChildCount(); i++) {
                View itemView = parent.getChildAt(i);
                itemView.setBackgroundColor(getResources().getColor(android.R.color.transparent)); // Reset background
            }

            // Create the Snackbar reference
            Snackbar snackbar;

            // Check if the selected option matches the correct answer
            if (selectedOption.equals(correctAnswer)) {
                // Change the background color of the selected option to green
                snackbar = Snackbar.make(view, "Correct!", Snackbar.LENGTH_INDEFINITE)
                        .setAction("Dismiss", v -> {
                        }) // Adds a dismiss action
                        .setActionTextColor(getResources().getColor(android.R.color.white));

                view.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
            } else {
                // Change the background color of the selected option to red
                snackbar = Snackbar.make(view, "Incorrect! Try again.", Snackbar.LENGTH_INDEFINITE)
                        .setAction("Dismiss", v -> {
                        }) // Adds a dismiss action
                        .setActionTextColor(getResources().getColor(android.R.color.white));

                view.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
            }

            // Show the Snackbar
            snackbar.show();

            // Dismiss the Snackbar after 1 seconds (1000 ms)
            new Handler().postDelayed(() -> snackbar.dismiss(), 1500);
        });
    }

    @Override
    public void onBackPressed() {
        // Retrieve the SubCategory data from the current intent
        SubCategory subCategory = (SubCategory) getIntent().getSerializableExtra("SUBCATEGORY");

        // Ensure the SubCategory data is passed back
        if (subCategory != null) {
            Intent intent = new Intent(OptionListActivity.this, QuestionListActivity.class);
            intent.putExtra("SUBCATEGORY", subCategory); // Pass the SubCategory again
            startActivity(intent);
        }

        super.onBackPressed();
    }
    @Override
    public boolean onSupportNavigateUp() {
        finish(); // Close the current activity and go back to the previous one
        return true;
    }


}