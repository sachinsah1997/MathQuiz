package com.sachinsah.mathapp;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

public class QuizActivity extends AppCompatActivity {

    private TextView textViewQuestionCount, textViewQuestion;
    private ProgressBar progressBarQuestionCount, progressBarTimer;
    private TextView textViewOptionOne, textViewOptionTwo, textViewOptionThird, textViewOptionFourth;
    private TextView textViewProgressTimer;
    private MaterialButton resultButton;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_questions);

        textViewQuestionCount = findViewById(R.id.textViewQuestionCount);
        progressBarQuestionCount = findViewById(R.id.progressBarQuestionCount);

        textViewQuestion = findViewById(R.id.textViewQuestion);
        textViewOptionOne = findViewById(R.id.tv_option_one);
        textViewOptionTwo = findViewById(R.id.tv_option_two);
        textViewOptionThird = findViewById(R.id.tv_option_three);
        textViewOptionFourth = findViewById(R.id.tv_option_four);

        progressBarTimer = findViewById(R.id.progressBarTimer);
        textViewProgressTimer = findViewById(R.id.tv_progress_time);


        resultButton = findViewById(R.id.buttonResult);

        Intent intent = getIntent();
        String operationType = intent.getStringExtra("questionType");
        final int[] count = new int[3];
        count[0] = 1;
        count[1] = questionGenerator(operationType, count[0]);
        new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                textViewProgressTimer.setText("" + (millisUntilFinished/1000));
                progressBarTimer.setProgress((int) (millisUntilFinished/1000));

                textViewOptionOne.setOnClickListener(v -> {
                        if(Integer.parseInt(textViewOptionOne.getText().toString()) == count[1]){
                               count[2]+=10;
                        }
                        onFinish();
                });

                textViewOptionTwo.setOnClickListener(v -> {
                    if(Integer.parseInt(textViewOptionTwo.getText().toString()) == count[1]){
                        count[2]+=10;
                    }
                    onFinish();
                });

                textViewOptionThird.setOnClickListener(v -> {
                    if(Integer.parseInt(textViewOptionThird.getText().toString()) == count[1]){
                        count[2]+=10;
                    }
                    onFinish();
                });

                textViewOptionFourth.setOnClickListener(v -> {
                    if(Integer.parseInt(textViewOptionFourth.getText().toString()) == count[1]){
                        count[2]+=10;
                    }
                    onFinish();
                });


            }

            public void onFinish() {

                if(count[0] <10) {
                    count[0] += 1;
                    count[1] = questionGenerator(operationType, count[0]);
                    start();
                }else{
                    textViewQuestion.setVisibility(View.GONE);
                    textViewProgressTimer.setVisibility(View.GONE);
                    progressBarTimer.setVisibility(View.GONE);

                    textViewOptionOne.setVisibility(View.GONE);
                    textViewOptionTwo.setVisibility(View.GONE);
                    textViewOptionThird.setVisibility(View.GONE);
                    textViewOptionFourth.setVisibility(View.GONE);

                    resultButton.setVisibility(View.VISIBLE);
                }
            }
        }.start();

        resultButton.setOnClickListener(v -> {
            Intent intentResult = new Intent(getApplicationContext(), ResultActivity.class);
            intentResult.putExtra("score", count[2]);
            startActivity(intentResult);
        });
    }

    @SuppressLint("SetTextI18n")
    protected int questionGenerator(String operator, int count) {

            textViewQuestionCount.setText(count + "/" + 10);
            progressBarQuestionCount.setProgress(count);

            int num1 = ThreadLocalRandom.current().nextInt(0, 100);
            int num2 = ThreadLocalRandom.current().nextInt(0, 100);
            int result = 0;

            if(operator.equals("add")) {
                textViewQuestion.setText(num1 + " + " + num2 + " ?");
                result = num1 + num2;
            }else if(operator.equals("sub")) {
                textViewQuestion.setText(num1 + " - " + num2 + " ?");
                result = num1 + num2;
            }else if(operator.equals("mul")) {
                textViewQuestion.setText(num1 + " * " + num2 + " ?");
                result = num1 + num2;
            }else if(operator.equals("div")) {
                textViewQuestion.setText(num1 + " / " + num2 + " ?");
                result = num1 + num2;
            }

            ArrayList<String> optionList = new ArrayList<>();
            optionList.add(result+"");
            optionList.add(result+5+"");
            optionList.add(result-6+"");
            optionList.add(result+10+"");

        Collections.shuffle(optionList);
        textViewOptionOne.setText(optionList.get(0));
            textViewOptionTwo.setText(optionList.get(1));
            textViewOptionThird.setText(optionList.get(2));
            textViewOptionFourth.setText(optionList.get(3));

            return result;
        }
}