package com.example.hostelmanagement;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.cardview.widget.CardView;
import android.content.Intent;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public CardView card1, card2, card3, card4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        card1 = (CardView) findViewById(R.id.cardhome);
        card2 = (CardView) findViewById(R.id.cardinfo);
        card3 = (CardView) findViewById(R.id.cardcomplaint);
        card4 = (CardView) findViewById(R.id.cardnoti);

        card1.setOnClickListener(this);
        card2.setOnClickListener(this);
        card3.setOnClickListener(this);
        card4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cardinfo:
            startActivity(new Intent(MainActivity.this, Studentprofilepage.class));
            break;
        }
    }
}
