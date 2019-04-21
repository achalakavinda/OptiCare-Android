package com.opensource.eye.opticare;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.nightonke.boommenu.BoomButtons.SimpleCircleButton;
import com.nightonke.boommenu.BoomMenuButton;
import com.opensource.eye.opticare.Configs.Config;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener{

    private Intent intent;
    private LinearLayout linearLayoutAcuity;
    private LinearLayout linearLayoutAstigmatism;
    private LinearLayout linearLayoutMypopia;
    private LinearLayout linearLayoutHyperopia;
    private LinearLayout linearLayoutPresbyopia;
    private LinearLayout linearLayoutNearBy;
    private LinearLayout linearLayoutReminder;
    private LinearLayout linearLayoutProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        linearLayoutAstigmatism = findViewById(R.id.linearLayoutAstigmatism);
        linearLayoutMypopia = findViewById(R.id.linearLayoutMyopia);
        linearLayoutHyperopia = findViewById(R.id.linearLayoutHyperopia);
        linearLayoutPresbyopia = findViewById(R.id.linearLayoutPresbyopia);
        linearLayoutNearBy = findViewById(R.id.linearLayoutNearBy);
        linearLayoutReminder = findViewById(R.id.linearLayoutReminder);
        linearLayoutProfile = findViewById(R.id.linearLayoutProfile);

        linearLayoutAstigmatism.setOnClickListener(this);
        linearLayoutMypopia.setOnClickListener(this);
        linearLayoutHyperopia.setOnClickListener(this);
        linearLayoutPresbyopia.setOnClickListener(this);
        linearLayoutNearBy.setOnClickListener(this);
        linearLayoutReminder.setOnClickListener(this);
        linearLayoutProfile.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        Bundle bundle = new Bundle();

        switch (v.getId()){
            case R.id.linearLayoutMyopia://short sightedness
                intent = new Intent(this,TutorialActivity.class);
                bundle.putInt("TYPE_CONST",Config.MYOPIA_ACTIVTY);
                intent.putExtras(bundle);
                startActivity(intent);
                break;

            case R.id.linearLayoutHyperopia://far sightedness
                intent = new Intent(this,TutorialActivity.class);
                bundle.putInt("TYPE_CONST",Config.HYPEROPIA_ACTIVTY);
                intent.putExtras(bundle);
                startActivity(intent);
                break;

            case R.id.linearLayoutReminder:
                intent = new Intent(this,PatientReminderActivity.class);
                startActivity(intent);
                break;

            case R.id.linearLayoutNearBy:
                intent = new Intent(this,MapActivity.class);
                startActivity(intent);
                break;
        }

    }
}
