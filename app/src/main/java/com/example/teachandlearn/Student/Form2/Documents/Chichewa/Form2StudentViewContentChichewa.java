

package com.example.teachandlearn.Student.Form2.Documents.Chichewa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.teachandlearn.R;
import com.example.teachandlearn.Student.Form2.Documents.Biology.Form2Audio;
import com.example.teachandlearn.Student.Form2.Documents.Biology.Form2PDF;
import com.example.teachandlearn.Student.Form2.Documents.Biology.Form2QuizzesAndQuestions;
import com.example.teachandlearn.Student.Form2.Documents.Biology.Form2Videos;


public class Form2StudentViewContentChichewa extends AppCompatActivity {
    private Button buttonBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form2_chemistry_view_content);

        // Find buttons for PDF, Audio, Videos, and Questions
        Button buttonPDF = findViewById(R.id.button_pdf);
        Button buttonAudio = findViewById(R.id.button_audio);
        Button buttonVideos = findViewById(R.id.button_videos);
        Button buttonQuestions = findViewById(R.id.button_tests_quizzes);
        buttonBack = findViewById(R.id.back_button);

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Logic for when the back button is pressed
                onBackPressed();
            }
        });

        // Set click listeners for each button
        buttonPDF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Form2StudentViewContentChichewa.this, Form2PDF.class);
                startActivity(intent);
            }
        });

        buttonAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Form2StudentViewContentChichewa.this, Form2Audio.class);
                startActivity(intent);
            }
        });

        buttonVideos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Form2StudentViewContentChichewa.this, Form2Videos.class);
                startActivity(intent);
            }
        });

        buttonQuestions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Form2StudentViewContentChichewa.this, Form2QuizzesAndQuestions.class);
                startActivity(intent);
            }
        });

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Logic for when the back button is pressed
                onBackPressed();
            }
        });


    }

    @Override
    public void onBackPressed() {
        // Handle the back button action
        super.onBackPressed();
        // You can also add custom logic here if needed
    }
}