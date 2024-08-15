package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class SuccessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the button by ID
        Button btnGoToRecyclerView = findViewById(R.id.btnGoToRecyclerView);
        Button btnGoToGridView = findViewById(R.id.btnGoToGridView);

        // Set an OnClickListener to handle button clicks
        btnGoToRecyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start RecyclerViewActivity when the button is clicked
                Intent intent = new Intent(SuccessActivity.this, RecyclerActivity.class);
                startActivity(intent);
            }
        });

        // Set OnClickListener for GridView button
        btnGoToGridView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SuccessActivity.this, GridViewActivity.class);
                startActivity(intent);
            }
        });
    }
}
