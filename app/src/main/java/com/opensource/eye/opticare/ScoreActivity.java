package com.opensource.eye.opticare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ScoreActivity extends AppCompatActivity implements View .OnClickListener{

    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        button = findViewById(R.id.buttonBack);
        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.buttonBack:

                Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                startActivity(intent);
                finish();

                break;
        }

    }
}
