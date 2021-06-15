package com.sachinsah.mathapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DashboardActivity extends AppCompatActivity {

    private TextView textViewName;
    private RelativeLayout relativeLayoutAddition, relativeLayoutSubtract, relativeLayoutMultiply, relativeLayoutDivision;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Retrieving the value using its keys the file name
        // must be same in both saving and retrieving the data
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);

        // The value will be default as empty string because for
        // the very first time when the app is opened, there is nothing to show
        String userName = sharedPreferences.getString("name", "");

        // We can then use the data
        textViewName = findViewById(R.id.textViewName);
        textViewName.setText(textViewName.getText().toString().trim() + " " + userName);


        relativeLayoutAddition = findViewById(R.id.relativeLayoutAddition);
        relativeLayoutSubtract = findViewById(R.id.relativeLayoutSubtract);
        relativeLayoutMultiply = findViewById(R.id.relativeLayoutmultiply);
        relativeLayoutDivision = findViewById(R.id.relativeLayoutDivision);

        Intent intent = new Intent(getApplicationContext(), QuizActivity.class);

        relativeLayoutAddition.setOnClickListener(v -> {
            intent.putExtra("questionType", "add");
            startActivity(intent);
        });
        relativeLayoutSubtract.setOnClickListener(v -> {
            intent.putExtra("questionType", "sub");
            startActivity(intent);
        });
        relativeLayoutMultiply.setOnClickListener(v -> {
            intent.putExtra("questionType", "mul");
            startActivity(intent);
        });relativeLayoutDivision.setOnClickListener(v -> {
            intent.putExtra("questionType", "div");
            startActivity(intent);
        });

    }
}
