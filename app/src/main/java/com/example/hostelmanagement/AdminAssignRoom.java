package com.example.hostelmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class AdminAssignRoom extends AppCompatActivity {

    private Button backButton;
    private Spinner studentSpinner;
    private Spinner roomSpinner;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_assign_room);

        backButton=findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent( AdminAssignRoom.this,AdminHomePAge.class);
                startActivity(intent);
            }
        });

        studentSpinner = findViewById(R.id.student_spinner);
        roomSpinner = findViewById(R.id.room_spinner);

        ArrayAdapter<CharSequence> studentAdapter = ArrayAdapter.createFromResource(this,
                R.array.student_array, android.R.layout.simple_spinner_item);
        studentAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        studentSpinner.setAdapter(studentAdapter);

        ArrayAdapter<CharSequence> roomAdapter = ArrayAdapter.createFromResource(this,
                R.array.room_array, android.R.layout.simple_spinner_item);
        roomAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        roomSpinner.setAdapter(roomAdapter);

        studentSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String student = parent.getItemAtPosition(position).toString();
                String room = roomSpinner.getSelectedItem().toString();
                assignStudentToRoom(student, room);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });

        roomSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String student = studentSpinner.getSelectedItem().toString();
                String room = parent.getItemAtPosition(position).toString();
                assignStudentToRoom(student, room);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });
    }

    private void assignStudentToRoom(String student, String room) {
        // Code to handle the assignment of students to rooms (e.g., database update, etc.)
        // ...
    }}