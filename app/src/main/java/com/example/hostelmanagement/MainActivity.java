package com.example.hostelmanagement;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.cardview.widget.CardView;
import android.content.Intent;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private CardView cardroom, cardinfo, card3, card4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardroom = (CardView) findViewById(R.id.cardroom);
        cardinfo = (CardView) findViewById(R.id.cardinfo);
        card3 = (CardView) findViewById(R.id.cardcomplaint);
        card4 = (CardView) findViewById(R.id.cardnoti);

        cardroom.setOnClickListener((View.OnClickListener)this);
        cardinfo.setOnClickListener((View.OnClickListener)this);
        card3.setOnClickListener((View.OnClickListener)this);
        card4.setOnClickListener((View.OnClickListener)this);
    }

    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()) {
            case R.id.cardinfo: i=new Intent(this,StudentProfile.class);
            startActivity(i);
            break;
            case R.id.cardroom: i=new Intent(this,StudentRoomDetails.class);
                startActivity(i);
                break;
        }
    }
}
