package com.opensource.eye.opticare;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.nightonke.boommenu.BoomButtons.SimpleCircleButton;
import com.nightonke.boommenu.BoomMenuButton;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener{

    private Intent intent;
    private BoomMenuButton bmb;
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

        bmb = (BoomMenuButton) findViewById(R.id.bmb);
        for (int i = 0; i < bmb.getPiecePlaceEnum().pieceNumber(); i++) {
            SimpleCircleButton.Builder builder = new SimpleCircleButton.Builder()
                    .normalImageRes(R.drawable.person);
            bmb.addBuilder(builder);
            bmb.setRippleEffect(true);
            bmb.setNormalColor(getResources().getColor(R.color.gradStop));
        }

        linearLayoutAcuity = findViewById(R.id.linearLayoutAcuity);
        linearLayoutAstigmatism = findViewById(R.id.linearLayoutAstigmatism);
        linearLayoutMypopia = findViewById(R.id.linearLayoutMyopia);
        linearLayoutHyperopia = findViewById(R.id.linearLayoutHyperopia);
        linearLayoutPresbyopia = findViewById(R.id.linearLayoutPresbyopia);
        linearLayoutNearBy = findViewById(R.id.linearLayoutNearBy);
        linearLayoutReminder = findViewById(R.id.linearLayoutReminder);
        linearLayoutProfile = findViewById(R.id.linearLayoutProfile);

        linearLayoutAcuity.setOnClickListener(this);
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

        switch (v.getId()){
            case R.id.linearLayoutAcuity:
                intent = new Intent(this,TutorialActivity.class);
                startActivity(intent);
                break;
        }

    }
}
