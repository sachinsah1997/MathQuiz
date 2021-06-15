package com.sachinsah.mathapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class ResultActivity extends AppCompatActivity {

    private TextView textViewScore;
    private MaterialButton backToDashBoardButton;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        int score = intent.getIntExtra("score",0);

        textViewScore = findViewById(R.id.textViewScore);
        textViewScore.setText(score+ "/" + 100);

        backToDashBoardButton = findViewById(R.id.ma_dashboard);

        backToDashBoardButton.setOnClickListener(v -> {
            Intent backToDashboardIntent = new Intent(getApplicationContext(), DashboardActivity.class);
            startActivity(backToDashboardIntent);
        });
    }
}