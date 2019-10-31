package com.ramadan.ramadanalert;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class about extends AppCompatActivity {
    TextView txt1,txt2,txt3,txt4,txt5,txt6,txt7,txt8,txt9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        txt1=findViewById(R.id.thisapp);
        txt2=findViewById(R.id.name);
        txt3=findViewById(R.id.id0);
        txt4=findViewById(R.id.nzhm);
        txt5=findViewById(R.id.id1);
        txt6=findViewById(R.id.ashq);
        txt7=findViewById(R.id.id2);
        txt8=findViewById(R.id.sam);
        txt9=findViewById(R.id.id3);
    }
}
