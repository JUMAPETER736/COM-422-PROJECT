

package com.example.teachandlearn.Student.Form1.Documents.Bible_Knowledge;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.teachandlearn.CHATGPT.ChatGPTService;
import com.example.teachandlearn.R;



public class Form1StudentViewContentBible_Knowledge extends AppCompatActivity {

    private Button buttonBack;

    private Button buttonChat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form1_bibleknowledge_view_content);

        // Find buttons for PDF, Audio, Videos, and Questions
        Button buttonPDF = findViewById(R.id.button_pdf);
        Button buttonAudio = findViewById(R.id.button_audio);
        Button buttonVideos = findViewById(R.id.button_videos);
        Button buttonQuestions = findViewById(R.id.button_tests_quizzes);
        buttonBack = findViewById(R.id.back_button);


        // Set click listeners for each button
        buttonPDF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Form1StudentViewContentBible_Knowledge.this, Form1PDFBible_Knowledge.class);
                startActivity(intent);
            }
        });

        buttonAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Form1StudentViewContentBible_Knowledge.this, Form1AudioBible_Knowledge.class);
                startActivity(intent);
            }
        });

        buttonVideos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Form1StudentViewContentBible_Knowledge.this, Form1VideosBible_Knowledge.class);
                startActivity(intent);
            }
        });

        buttonQuestions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Form1StudentViewContentBible_Knowledge.this, Form1QuizzesAndQuestionsBible_Knowledge.class);
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

        buttonChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open chat interface
                openChatInterface();
            }
        });

    }


    private void openChatInterface() {
        // Handle logic for opening the chat interface
        // For example, start the ChatGPTService
        Intent intent = new Intent(this, ChatGPTService.class);
        startService(intent);

    }
    @Override
    public void onBackPressed() {
        // Handle the back button action
        super.onBackPressed();
        // You can also add custom logic here if needed
    }

}