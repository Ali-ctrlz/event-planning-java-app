package com.example.eventplanning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class logIn extends AppCompatActivity {
    database1 myDB;
    EditText email;
    EditText password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        email = (EditText)findViewById(R.id.editTextText3);
        password = (EditText) findViewById(R.id.editTextText2);
        login = (Button)findViewById(R.id.button10);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email1 = email.getText().toString();
                String password1 = password.getText().toString();
                if (login(email1, password1)) {
                    // Start main activity
                    Intent intent = new Intent(logIn.this, MainApp.class);
                    startActivity(intent);
                } else {
                    // Display error message
                    Toast.makeText(logIn.this, "Invalid email or password", Toast.LENGTH_SHORT).show();
                }
            }
        });
}


    private boolean login(String email, String password) {
        // Query the database for a user with the given email and password
        database1 dbHelper = new database1(this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String[] projection = {
                database1.COLUMN_ID,
                database1.COLUMN_CUSTOMER_EMAIL,
                database1.COLUMN_CUSTOMER_PASSWORD
        };
        String selection = database1.COLUMN_CUSTOMER_EMAIL + " = ? AND " + database1.COLUMN_CUSTOMER_PASSWORD + " = ?";
        String[] selectionArgs = {email, password};
        Cursor cursor = db.query(
                database1.CUSTOMER_TABLE1,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
        );

        // Handle the result of the query
        boolean success = false;
        if (cursor.moveToFirst()) {
            success = true;
        }
        cursor.close();
        db.close();
        return success;
    }
        public void openMainApp() {
        Intent intent = new Intent(this, MainApp.class);
        startActivity(intent);
    }

}