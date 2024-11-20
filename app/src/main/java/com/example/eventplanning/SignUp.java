package com.example.eventplanning;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

import com.example.eventplanning.R;

public class SignUp extends AppCompatActivity {
    Button sumbit;

    EditText Name;
    EditText email;
    EditText pass1;
    EditText pass2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        email = (EditText) findViewById(R.id.editTextTextEmailAddress);
        pass1 = (EditText) findViewById(R.id.editTextTextPassword);
        pass2 = (EditText) findViewById(R.id.editTextTextPassword2);
        Name = (EditText) findViewById(R.id.editTextText);
        sumbit = (Button) findViewById(R.id.button3);


        Customers customer;
        sumbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateEmail(email) == true && validatePassWord(pass1, pass2) == true) {
                    database1 db1 = new database1(SignUp.this);
                    Customers customer = new Customers(-1, Name.getText().toString(), pass2.getText().toString(), email.getText().toString());
                    boolean success = db1.addOne(customer);
                    Toast.makeText(SignUp.this, "Success " + success, Toast.LENGTH_SHORT).show();
                    openMainApp();

                }
            }
        });
    }

    public void openMainApp() {
        Intent intent = new Intent(this, MainApp.class);
        startActivity(intent);
    }

    private boolean validateEmail(EditText email) {
        String emailInput = email.getText().toString();
        if (!emailInput.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            return true;
        } else {
            Toast.makeText(this, "Invalid Email", Toast.LENGTH_LONG).show();
            return false;
        }
    }

    boolean validatePassWord(EditText pass1, EditText pass2) {
        String passWordInput1 = pass1.getText().toString();
        String passWordInput2 = pass2.getText().toString();
        if (passWordInput1.isEmpty() || passWordInput2.isEmpty()) {
            Toast.makeText(this, "Password Field Is Empty", Toast.LENGTH_LONG).show();
            return false;
        }
        if (passWordInput1.equals(passWordInput2)) {
            return true;
        } else {
            Toast.makeText(this, "Invalid Password", Toast.LENGTH_LONG).show();
            return false;
        }
    }
}
