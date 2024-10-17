package com.example.intent_assignmentclass_4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class DisplayImageActivity extends AppCompatActivity {

    ImageView imageView1, imageView2, imageView3, imageView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_image);

        // Initialize the ImageViews
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);

        // Get image resource IDs from the intent
        Intent intent = getIntent();
        int[] imageResIds = intent.getIntArrayExtra("imageResources");

        if (imageResIds != null && imageResIds.length <= 4) {
            // Set images to the ImageViews
            imageView1.setImageResource(imageResIds[0]);
            imageView2.setImageResource(imageResIds[1]);
            imageView3.setImageResource(imageResIds[2]);
            imageView4.setImageResource(imageResIds[3]);
        }
        imageView1.setOnClickListener(v -> returnImage(imageResIds[0]));
        imageView2.setOnClickListener(v -> returnImage(imageResIds[1]));
        imageView3.setOnClickListener(v -> returnImage(imageResIds[2]));
        imageView4.setOnClickListener(v -> returnImage(imageResIds[3]));
    }

    private void returnImage(int imageResId) {
        Intent resultIntent = new Intent();
        resultIntent.putExtra("selectedImageResId", imageResId);
        setResult(RESULT_OK, resultIntent);
        finish();
    }
}