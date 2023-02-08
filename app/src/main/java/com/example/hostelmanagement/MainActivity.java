package com.example.hostelmanagement;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.cardview.widget.CardView;
import android.content.Intent;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CardView cardroom, cardinfo, cardcomplaint, cardnoti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardroom = findViewById(R.id.cardroom);
        cardinfo = findViewById(R.id.cardinfo);
        cardcomplaint =findViewById(R.id.cardcomplaint);
        cardnoti = findViewById(R.id.cardnoti);

        cardroom.setOnClickListener(this);
        cardinfo.setOnClickListener(this);
        cardcomplaint.setOnClickListener(this);
        cardnoti.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()) {
            case R.id.cardroom: i=new Intent(this,StudentRoomDetails.class);
                startActivity(i);
                break;
            case R.id.cardinfo: i=new Intent(this,StudentProfile.class);
            startActivity(i);
            break;
            case R.id.cardnoti: i=new Intent(this,LoginActivity.class);
                startActivity(i);
                break;
        }
    }
}
