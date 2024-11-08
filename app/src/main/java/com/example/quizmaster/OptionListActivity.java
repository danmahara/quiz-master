package com.example.quizmaster;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.snackbar.Snackbar;

public class OptionListActivity extends AppCompatActivity {

    private String correctAnswer; // Store the correct answer

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_list);



        // Retrieve the question text, options, and correct answer from the Intent
        String questionText = getIntent().getStringExtra("QUESTION_TEXT");
        String[] options = getIntent().getStringArrayExtra("OPTIONS");
        correctAnswer = getIntent().getStringExtra("CORRECT_ANSWER");

        // Set the question text
        TextView questionTextView = findViewById(R.id.questionTextView);
        questionTextView.setText(questionText);

        // Display options in a ListView
        ListView optionsListView = findViewById(R.id.optionsListView);
        OptionAdapter optionAdapter = new OptionAdapter(this, options);
        optionsListView.setAdapter(optionAdapter);

// // correct or incorrect msg with snackbar
//        optionsListView.setOnItemClickListener((parent, view, position, id) -> {
//            // Get the selected option
//            String selectedOption = options[position];
//
//            // Check if the selected option matches the correct answer
//            if (selectedOption.equals(correctAnswer)) {
//                // Show Snackbar with success message
//                Snackbar.make(view, "Correct!", Snackbar.LENGTH_SHORT).show();
//            } else {
//                // Show Snackbar with failure message
//                Snackbar.make(view, "Incorrect! Try again.", Snackbar.LENGTH_SHORT).show();
//            }
//        });


//         //  to add background color
//        optionsListView.setOnItemClickListener((parent, view, position, id) -> {
//            // Get the selected option
//            String selectedOption = options[position];
//
//            // Check if the selected option matches the correct answer
//            if (selectedOption.equals(correctAnswer)) {
//                // Change the background color of the selected option to green
//                view.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
//            } else {
//                // Change the background color of the selected option to red
//                view.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
//            }
//        });

// // correct or incorrect msg with snackbar and background color on options

//        optionsListView.setOnItemClickListener((parent, view, position, id) -> {
//            // Get the selected option
//            String selectedOption = options[position];
//
//            // Reset background color for all items
//            for (int i = 0; i < parent.getChildCount(); i++) {
//                View itemView = parent.getChildAt(i);
//                itemView.setBackgroundColor(getResources().getColor(android.R.color.transparent)); // Reset background
//            }
//
//            // Check if the selected option matches the correct answer
//            if (selectedOption.equals(correctAnswer)) {
//                // Change the background color of the selected option to green
//                Snackbar.make(view, "Correct!", Snackbar.LENGTH_SHORT).show();
//                view.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
//            } else {
//                // Change the background color of the selected option to red
//                Snackbar.make(view, "Incorrect! Try again.", Snackbar.LENGTH_SHORT).show();
//                view.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
//
//            }
//        });


// // // correct or incorrect msg with snackbar with dismiss button and background color on options
//        optionsListView.setOnItemClickListener((parent, view, position, id) -> {
//            // Get the selected option
//            String selectedOption = options[position];
//
//            // Reset background color for all items
//            for (int i = 0; i < parent.getChildCount(); i++) {
//                View itemView = parent.getChildAt(i);
//                itemView.setBackgroundColor(getResources().getColor(android.R.color.transparent)); // Reset background
//            }
//
//            // Check if the selected option matches the correct answer
//            if (selectedOption.equals(correctAnswer)) {
//                // Change the background color of the selected option to green
//                Snackbar.make(view, "Correct!", Snackbar.LENGTH_INDEFINITE)
//                        .setAction("Dismiss", v -> {}) // Adds a dismiss action
//                        .setActionTextColor(getResources().getColor(android.R.color.white))
//                        .show();
//                view.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
//            } else {
//                // Change the background color of the selected option to red
//                Snackbar.make(view, "Incorrect! Try again.", Snackbar.LENGTH_INDEFINITE)
//                        .setAction("Dismiss", v -> {}) // Adds a dismiss action
//                        .setActionTextColor(getResources().getColor(android.R.color.white))
//                        .show();
//                view.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
//            }
//        });


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
                        .setAction("Dismiss", v -> {}) // Adds a dismiss action
                        .setActionTextColor(getResources().getColor(android.R.color.white));

                view.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
            } else {
                // Change the background color of the selected option to red
                snackbar = Snackbar.make(view, "Incorrect! Try again.", Snackbar.LENGTH_INDEFINITE)
                        .setAction("Dismiss", v -> {}) // Adds a dismiss action
                        .setActionTextColor(getResources().getColor(android.R.color.white));

                view.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
            }

            // Show the Snackbar
            snackbar.show();

            // Dismiss the Snackbar after 1 seconds (1000 ms)
            new Handler().postDelayed(() -> snackbar.dismiss(), 1500);
        });




    }
}