package com.example.intent_assignmentclass_4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    Button btntiger, btncat, btnelephant,btndog ;
    private static final int IMAGE_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        initializeViews();
        initializeListeners();
    }

    private void initializeViews() {
        imageView = findViewById(R.id.imageView);
        btndog = findViewById(R.id.btntiger);
        btncat = findViewById(R.id.btncat);
        btntiger = findViewById(R.id.btnelephant);
        btnelephant = findViewById(R.id.btndog);
    }

    private void initializeListeners() {
        btndog.setOnClickListener(v -> sendImagesToDisplayActivity(new int[]{R.drawable.tiger1, R.drawable.tiger2, R.drawable.tiger3, R.drawable.tiger4}));
        btncat.setOnClickListener(v -> sendImagesToDisplayActivity(new int[]{R.drawable.cat1, R.drawable.cat2, R.drawable.cat3, R.drawable.cat4}));
        btntiger.setOnClickListener(v -> sendImagesToDisplayActivity(new int[]{R.drawable.elephant1, R.drawable.elephant2, R.drawable.elephant3, R.drawable.elephant4}));
        btnelephant.setOnClickListener(v -> sendImagesToDisplayActivity(new int[]{R.drawable.dog1, R.drawable.dog2, R.drawable.dog3, R.drawable.dog4}));
    }

    private void sendImagesToDisplayActivity(int[] imageResIds) {
        Intent intent = new Intent(MainActivity.this, DisplayImageActivity.class);
        intent.putExtra("imageResources", imageResIds);
        startActivityForResult(intent, IMAGE_REQUEST_CODE);
    }

    // Handle the result when returning from DisplayImageActivity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == IMAGE_REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            int selectedImageResId = data.getIntExtra("selectedImageResId", -1);
            if (selectedImageResId != -1) {
                // Set the selected image in the ImageView of MainActivity
                imageView.setImageResource(selectedImageResId);
            }
        }
    }
}