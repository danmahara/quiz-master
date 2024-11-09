package com.example.quizmaster;

import android.content.Context;
import android.content.SharedPreferences;

public class ScoreManager {

    private static final String PREFS_NAME = "QuizPrefs";
    private static final String KEY_SCORE = "score";
    private SharedPreferences sharedPreferences;

    public ScoreManager(Context context) {
        // Get the SharedPreferences instance
        sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    // Method to add score points
    public void addScore(int points) {
        // Get the current score from SharedPreferences
        int currentScore = sharedPreferences.getInt(KEY_SCORE, 0);
        currentScore += points;

        // Save the new score to SharedPreferences
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(KEY_SCORE, currentScore);
        editor.apply(); // Apply changes asynchronously
    }

    // Method to get the current score
    public int getScore() {
        return sharedPreferences.getInt(KEY_SCORE, 0);
    }

    // Method to reset the score
    public void resetScore() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(KEY_SCORE, 0);  // Reset score to 0
        editor.apply(); // Apply changes asynchronously
    }
}
