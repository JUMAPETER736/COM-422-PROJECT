package com.example.teachandlearn.Student.Form4.Documents;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.teachandlearn.R;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import java.util.ArrayList;


public class Form4QuizzesAndQuestions extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> pdfNames;
    private ArrayList<String> pdfUrls; // To store URLs of the PDFs

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form4_quizzes_and_questions);

        listView = findViewById(R.id.list_view);
        pdfNames = new ArrayList<>();
        pdfUrls = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, pdfNames);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String url = pdfUrls.get(position);
                Intent intent = new Intent(Form4QuizzesAndQuestions.this, Form4PDFViewer.class);
                intent.putExtra("PDF_URL", url);
                startActivity(intent);
            }
        });

        loadPDFsFromStorage();
    }

    private void loadPDFsFromStorage() {
        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageRef;



        storageRef = FirebaseStorage.getInstance().getReference().child("/form4/humanities/geography/quizzes_and_questions/");

        storageRef = FirebaseStorage.getInstance().getReference().child("/form4/humanities/history/quizzes_and_questions/");

        storageRef = FirebaseStorage.getInstance().getReference().child("/form4/humanities/life_skills/quizzes_and_questions/");

        storageRef = FirebaseStorage.getInstance().getReference().child("/form4/humanities/social_studies/quizzes_and_questions/");

        storageRef = FirebaseStorage.getInstance().getReference().child("/form4/languages/english/quizzes_and_questions/");

        storageRef = FirebaseStorage.getInstance().getReference().child("/form4/languages/chichewa/quizzes_and_questions/");

        storageRef = FirebaseStorage.getInstance().getReference().child("/form4/sciences/agriculture/quizzes_and_questions/");

        storageRef = FirebaseStorage.getInstance().getReference().child("/form4/sciences/biology/quizzes_and_questions/");

        storageRef = FirebaseStorage.getInstance().getReference().child("/form4/sciences/chemistry/quizzes_and_questions/");

        storageRef = FirebaseStorage.getInstance().getReference().child("/form4/sciences/mathematics/quizzes_and_questions/");

        storageRef = FirebaseStorage.getInstance().getReference().child("/form4/sciences/physics/quizzes_and_questions/");


        storageRef.listAll().addOnSuccessListener(listResult -> {
            if (listResult.getItems().isEmpty()) {
                // If no documents are found, show "No file Uploaded" message
                showNoFilesUploaded();
            } else {
                for (StorageReference item : listResult.getItems()) {
                    String name = item.getName();
                    String url = item.getDownloadUrl().toString();
                    pdfNames.add(name);
                    pdfUrls.add(url);
                    adapter.notifyDataSetChanged();
                }
            }
        }).addOnFailureListener(exception -> {
            // Handle the error
            Toast.makeText(Form4QuizzesAndQuestions.this, "Failed to load past papers", Toast.LENGTH_SHORT).show();
        });
    }

    private void showNoFilesUploaded() {
        // Clear the existing list of PDFs
        pdfNames.clear();
        pdfUrls.clear();
        adapter.notifyDataSetChanged();
        // Display "No file Uploaded" message
        Toast.makeText(this, "No file Uploaded", Toast.LENGTH_SHORT).show();
    }
}