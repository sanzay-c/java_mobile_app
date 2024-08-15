package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextUsername, editTextEmail, editTextPassword;
    private RadioGroup radioGroupGender;
    private Spinner spinnerCountry;
    private Button buttonSignUp;
    private UserDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linear_layout);

        editTextUsername = findViewById(R.id.username);
        editTextPassword = findViewById(R.id.password);
        editTextEmail = findViewById(R.id.email);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        spinnerCountry = findViewById(R.id.spinnerCountry);
        buttonSignUp = findViewById(R.id.buttonSignUp);

        dbHelper = new UserDatabaseHelper(this);

        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUp();
            }
        });
    }


    private void signUp() {
        String username = editTextUsername.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();
        int selectedGenderId = radioGroupGender.getCheckedRadioButtonId();
        RadioButton selectedGender = findViewById(selectedGenderId);
        String gender = selectedGender != null ? selectedGender.getText().toString() : "";
        String country = spinnerCountry.getSelectedItem().toString();


        if (TextUtils.isEmpty(username)) {
            editTextUsername.setError("Username is required");
            return;
        }

        if (TextUtils.isEmpty(email)) {
            editTextEmail.setError("Email is required");
            return;
        }

        if (TextUtils.isEmpty(password)) {
            editTextPassword.setError("Password is required");
            return;
        }

        if (username.isEmpty() || password.isEmpty() || email.isEmpty() || gender.isEmpty() || country.isEmpty()) {
            Toast.makeText(this, "Please Fill All The Fields", Toast.LENGTH_SHORT).show();
        } else {
            // Insert user data into the database
            insertUserIntoDatabase(username, password, email, gender, country);


            /* * method is call to see the user data in logcat.
               * You can call the logAllUsers method from within the signUp method or any other method where you want to verify the data
                // Log all users to verify data
                logAllUsers();
             */

            Intent intent = new Intent(MainActivity.this, SuccessActivity.class);
            startActivity(intent);

            Toast.makeText(this, "Sign Up Successful", Toast.LENGTH_SHORT).show();
        }
    }


    private void insertUserIntoDatabase(String username, String password, String email, String gender, String country) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("username", username);
        values.put("password", password);
        values.put("email", email);
        values.put("gender", gender);
        values.put("country", country);
//        db.insert("users", null, values);

        long newRowId = db.insert("users", null, values);

        // Log the result to confirm insertion
        if (newRowId != -1) {
            Log.d("Database", "User inserted with row ID: " + newRowId);
        } else {
            Log.d("Database", "User insertion failed");
        }
    }

    /* * method to retrieve the data.
       * You can call this method from your MainActivity or any other appropriate place to log the data.
        private void logAllUsers() {
            Cursor cursor = dbHelper.getAllUsers();
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    String username = cursor.getString(cursor.getColumnIndexOrThrow("username"));
                    String email = cursor.getString(cursor.getColumnIndexOrThrow("email"));
                    String gender = cursor.getString(cursor.getColumnIndexOrThrow("gender"));
                    String country = cursor.getString(cursor.getColumnIndexOrThrow("country"));

                    Log.d("Database", "User: " + username + ", Email: " + email + ", Gender: " + gender + ", Country: " + country);
                }
                cursor.close();
            } else {
                Log.d("Database", "No data found");
            }
        }
     */
}
