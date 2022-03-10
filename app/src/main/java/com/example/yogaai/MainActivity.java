package com.example.yogaai;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView welcome = (TextView)findViewById(R.id.WelcomeName);
        ImageButton exe = (ImageButton)findViewById(R.id.exerc);
        ImageButton yoga = (ImageButton)findViewById(R.id.yoga);
        //EditText username = (EditText)findViewById(R.id.yourname);
        //String value = username.getText().toString();


        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int hour = cal.get(Calendar.HOUR_OF_DAY);

        String greeting = null;
        if(hour>=1 && hour<12){
            greeting = "Good Morning";
        }
        else if(hour>=12 && hour<15){
            greeting = "Good Afternoon";
        }
        else{
            greeting = "Good Evening";
        }

        welcome.setText(greeting+" "+"User");

        exe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,exercise.class);
                startActivity(intent);
            }
        });
        yoga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,yogastart.class);
                startActivity(i);
            }
        });


    }
}