package com.example.myapplication;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class RecyclerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Create a list of users
        List<User> userList = new ArrayList<>();
        userList.add(new User("Ram", 30, 165.5f, "ram@email.com", 1234567890L));
        userList.add(new User("Shyam", 25, 175.0f, "shyam@gmail.com", 9876543210L));
        userList.add(new User("Sita", 18, 170.0f, "sita@gmail.com", 9876543210L));
        userList.add(new User("Geeta", 20, 165.0f, "geeta@gmail.com", 9876543210L));
        // Add more users as needed

        UserAdapter adapter = new UserAdapter(userList);
        recyclerView.setAdapter(adapter);

        // Set up the back button
        Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // This closes the current activity and returns to the previous one
            }
        });
    }
}
