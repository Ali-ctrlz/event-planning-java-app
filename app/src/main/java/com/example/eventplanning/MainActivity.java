package com.example.eventplanning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
public class MainActivity extends AppCompatActivity {
Button signUp;
Button logIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        signUp = (Button)findViewById(R.id.button);
        logIn = (Button)findViewById(R.id.button2);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opensignup();
            }
        });
        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openlogin();
            }
        });
    }
    public void opensignup(){
        Intent intent = new Intent(this, SignUp.class);
        startActivity(intent);
    }
    public void openlogin(){
        Intent intent = new Intent(this, logIn.class);
        startActivity(intent);
    }
}