package com.example.hostelmanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AdminHomePAge extends AppCompatActivity implements View.OnClickListener{
    private CardView room, info, complaint, noti;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home_page);
        room = (CardView) findViewById(R.id.room);
        info = (CardView) findViewById(R.id.info);
        complaint = (CardView) findViewById(R.id.complaint);
        noti = (CardView) findViewById(R.id.noti);

        room.setOnClickListener((View.OnClickListener)this);
        info.setOnClickListener((View.OnClickListener)this);
        complaint.setOnClickListener((View.OnClickListener)this);
        noti.setOnClickListener((View.OnClickListener)this);
    }

    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()) {
            case R.id.room: i=new Intent(this,AdminAssignRoom.class);
                startActivity(i);
                break;
            case R.id.noti: i=new Intent(this,LoginActivityAdmin.class);
                startActivity(i);
                break;
        }
    }
}
