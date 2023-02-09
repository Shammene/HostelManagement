package com.example.hostelmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;



public class complaint_Student extends AppCompatActivity{
private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint_student);

        button=findViewById(R.id.button);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent( complaint_Student.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}