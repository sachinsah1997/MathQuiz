package com.sachinsah.mathapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    private MaterialButton continueButton;
    private EditText editTextName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.user_name);

        //continue button
        continueButton = findViewById(R.id.ma_continue);
        continueButton.setOnClickListener(v -> {

            // Storing data into SharedPreferences
            SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);

            // Creating an Editor object to edit(write to the file)
            SharedPreferences.Editor myEdit = sharedPreferences.edit();

            // Storing the key and its value as the data fetched from edittext
            myEdit.putString("name", editTextName.getText().toString().trim());

            // Once the changes have been made,
            // we need to commit to apply those changes made, otherwise, it will throw an error
            myEdit.apply();

            //Intent
            Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
            startActivity(intent);
        });
    }
}