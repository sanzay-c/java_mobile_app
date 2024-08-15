package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class GridViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        GridView gridView = findViewById(R.id.gridView);
        Button backButton = findViewById(R.id.backButton);

        // Create a list of users
        List<User> userList = new ArrayList<>();
        userList.add(new User("Ram", 30, 165.5f, "ram@email.com", 1234567890L));
        userList.add(new User("Shyam", 25, 175.0f, "shyam@gmail.com", 9876543210L));
        userList.add(new User("Sita", 18, 170.0f, "sita@gmail.com", 9876543210L));
        userList.add(new User("Geeta", 20, 165.0f, "geeta@gmail.com", 9876543210L));
        // Add more users as needed

        GridViewAdapter adapter = new GridViewAdapter(this, userList);
        gridView.setAdapter(adapter);

        // Set onClickListener for the back button
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // This will close the current activity and return to the previous one
            }
        });
    }
}
