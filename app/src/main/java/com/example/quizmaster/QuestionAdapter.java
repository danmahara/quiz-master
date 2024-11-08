package com.example.quizmaster;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class QuestionAdapter extends BaseAdapter {
    private Context context;
    private List<Question> questionList;

    public QuestionAdapter(Context context, List<Question> questionList) {
        this.context = context;
        this.questionList = questionList;
    }

    @Override
    public int getCount() {
        return questionList.size();
    }

    @Override
    public Object getItem(int position) {
        return questionList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Inflate the view if it is null
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.question_item, parent, false);
        }

        // Get the question item for the current position
        Question currentQuestion = questionList.get(position);

        // Initialize the TextView for the question text
        TextView questionTextView = convertView.findViewById(R.id.questionText);

        if (questionTextView != null) {
            // Display the question number by adding 1 to the zero-based position
            questionTextView.setText((position + 1) + ". " + currentQuestion.getQuestionText());
        } else {
            // Log an error if the TextView is null
            Log.e("QuestionAdapter", "TextView is null");
        }

        return convertView;
    }



}

