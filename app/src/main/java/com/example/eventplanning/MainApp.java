package com.example.eventplanning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.content.Intent;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;

public class MainApp extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    Spinner spinner;
    Spinner spinner2;
    Button date;
    Button confirm;
    String[] venues = {"location","Mokattam","Masr el Gdida","6 october","Tagamoa","Mohandesin"};
    String[] type = {"Select service type","batchelor party","graduation","meeting","wedding","farwell"};
    EVENTS event = new EVENTS(" ", " ","",1);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_app);
        confirm = (Button)findViewById(R.id.button4);
        date = (Button)findViewById(R.id.button9);
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new com.example.eventplanning.DatePicker();
                datePicker.show(getSupportFragmentManager(),"date picker");
            }
        });
        spinner = findViewById(R.id.spinnerMain);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_activated_1,venues);
        spinner.setAdapter(adapter);
        spinner2=findViewById(R.id.spinnerTwo);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_activated_1,type);
        spinner2.setAdapter(adapter1);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database2 db = new database2(MainApp.this);
                EVENTS event = new EVENTS(spinner2.getSelectedItem().toString(), spinner.getSelectedItem().toString(),date.toString(),-1);
                boolean success = db.addTwo(event);
                Toast.makeText(MainApp.this, "Success " + success, Toast.LENGTH_SHORT).show();
                openPayments();
            }
        });
    }

    @Override
    public void onDateSet(android.widget.DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR,year);
        c.set(Calendar.MONTH,month);
        c.set(Calendar.DAY_OF_MONTH,dayOfMonth);
        String currentDateString = DateFormat.getDateInstance().format(c.getTime());
        TextView txt = (TextView) findViewById(R.id.textView12);
        txt.setText(currentDateString);
    }
    public void openPayments(){
        Intent intent = new Intent(this, payment.class);
        startActivity(intent);
    }
}