package com.opensource.eye.opticare;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import Models.User;
import Models.UserStatic;

public class ProfileActivity extends AppCompatActivity {

    TextView textViewInfoUsername;
    TextView textViewInfoUserType;
    TextView textUsername;
    TextView textEmail;

    TextView textAppointments;
    TextView textTest;
    TextView textCheckup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        textViewInfoUsername = findViewById(R.id.infoUsername);
        textViewInfoUserType = findViewById(R.id.infoUserType);
        textUsername = findViewById(R.id.textUsername);
        textEmail = findViewById(R.id.textEmail);

        textViewInfoUsername.setText(UserStatic.getUsername());
        textViewInfoUserType.setText(UserStatic.getUserType().toUpperCase());
        textUsername.setText(UserStatic.getUsername());
        textEmail.setText(UserStatic.getEmail());

        textAppointments = findViewById(R.id.textAppointments);
        textTest = findViewById(R.id.textTest);
        textCheckup = findViewById(R.id.textCheckup);

        textAppointments.setText("0");
        textTest.setText("0");
        textCheckup.setText("0");

    }
}
