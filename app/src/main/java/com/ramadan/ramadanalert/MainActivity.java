package com.ramadan.ramadanalert;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TextView txt;

    Button bt1,btniftar, namaz,about;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt1 = findViewById(R.id.btnStart);
        btniftar =findViewById(R.id.btniftar);
        namaz=findViewById(R.id.Namaz);
        txt=findViewById(R.id.textView);
        about=findViewById(R.id.about);


        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "You will get a Sehri Alert at 2:30AM daily!", Toast.LENGTH_SHORT).show();
                Calendar cal = Calendar.getInstance();

                cal.set(Calendar.HOUR_OF_DAY,2);
                cal.set(Calendar.MINUTE,30 );
                cal.set(Calendar.SECOND,0);

                Intent i = new Intent(getApplicationContext(),Notification_receiver.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(),100,i,PendingIntent.FLAG_UPDATE_CURRENT);
                AlarmManager alarmManager =(AlarmManager)getSystemService(ALARM_SERVICE);
                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(),AlarmManager.INTERVAL_DAY,pendingIntent);


            }




        });

        btniftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "You will get an Iftar Alert at 6:30PM daily!", Toast.LENGTH_SHORT).show();
                Calendar iftar = Calendar.getInstance();
                iftar.set(Calendar.HOUR_OF_DAY,18);
                iftar.set(Calendar.MINUTE,30 );
                iftar.set(Calendar.SECOND,0);

                Intent iftaar = new Intent(getApplicationContext(),iftar.class);
                PendingIntent pendingIntent2 = PendingIntent.getBroadcast(getApplicationContext(),100,iftaar,PendingIntent.FLAG_UPDATE_CURRENT);
                AlarmManager alarmManager2 =(AlarmManager)getSystemService(ALARM_SERVICE);
                alarmManager2.setRepeating(AlarmManager.RTC_WAKEUP,iftar.getTimeInMillis(),AlarmManager.INTERVAL_DAY,pendingIntent2);
            }
        });

        namaz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nmz = new Intent(MainActivity.this,HomeActivity.class);
                startActivity(nmz);
            }
        });

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,about.class);
                startActivity(i);
            }
        });



    }



}
