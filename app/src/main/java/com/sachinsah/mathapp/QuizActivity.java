package com.sachinsah.mathapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class QuizActivity extends AppCompatActivity {

    private TextView textViewQuestion;
    private ProgressBar progressBarQuestion;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_questions);

        textViewQuestion = findViewById(R.id.textViewQuestion);
        progressBarQuestion = findViewById(R.id.progressBarQuestion);

        for(int question = 1; question<=10; question++){

            textViewQuestion.setText(question + "/" + 10);
            progressBarQuestion.setProgress(question);

        }

    }
}