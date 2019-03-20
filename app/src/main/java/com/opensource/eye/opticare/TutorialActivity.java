package com.opensource.eye.opticare;

import android.animation.ArgbEvaluator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.opensource.eye.opticare.Adapters.TutorialItemsAdapter;
import com.opensource.eye.opticare.Configs.Config;
import com.opensource.eye.opticare.Models.TutorialItemModel;

import java.util.ArrayList;
import java.util.List;

public class TutorialActivity extends AppCompatActivity implements View .OnClickListener{

    ViewPager viewPager;
    TutorialItemsAdapter adapter;
    List<TutorialItemModel> tutorialItemModels;
    Integer[]  colours = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();
    Button buttonStartTest;

    int ViewPageInt = 0;
    Window window = null;
    Bundle bundle = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);
        buttonStartTest = findViewById(R.id.buttonStartTest);
        buttonStartTest.setOnClickListener(this);
        window = getWindow();
        bundle = getIntent().getExtras();
        ActivitySelector(bundle.getInt("TYPE_CONST"));
    }


    public void ActivitySelector(int ActityInteger){
        ViewPageInt = ActityInteger;
        tutorialItemModels = new ArrayList<>();
        switch (ActityInteger){
            case Config.MYOPIA_ACTIVTY:

                tutorialItemModels.add(new TutorialItemModel(R.drawable.brochure,"MYOPIA_ACTIVTY","Brocher"));
                tutorialItemModels.add(new TutorialItemModel(R.drawable.brochure,"MYOPIA_ACTIVTY X","Brocher sad asd dsa "));
                tutorialItemModels.add(new TutorialItemModel(R.drawable.brochure,"MYOPIA_ACTIVTY X","Brocher sad asd dsa "));
                tutorialItemModels.add(new TutorialItemModel(R.drawable.brochure,"MYOPIA_ACTIVTY X","Brocher sad asd dsa "));
                tutorialItemModels.add(new TutorialItemModel(R.drawable.brochure,"MYOPIA_ACTIVTY X","Brocher sad asd dsa "));
                tutorialItemModels.add(new TutorialItemModel(R.drawable.brochure,"MYOPIA_ACTIVTY X","Brocher sad asd dsa "));
                Render();
                break;
            case Config.HYPEROPIA_ACTIVTY:

                tutorialItemModels.add(new TutorialItemModel(R.drawable.brochure,"HYPEROPIA_ACTIVTY","Brocher"));
                tutorialItemModels.add(new TutorialItemModel(R.drawable.brochure,"HYPEROPIA_ACTIVTY X","Brocher sad asd dsa "));
                tutorialItemModels.add(new TutorialItemModel(R.drawable.brochure,"HYPEROPIA_ACTIVTY X","Brocher sad asd dsa "));
                tutorialItemModels.add(new TutorialItemModel(R.drawable.brochure,"HYPEROPIA_ACTIVTY X","Brocher sad asd dsa "));
                tutorialItemModels.add(new TutorialItemModel(R.drawable.brochure,"HYPEROPIA_ACTIVTY X","Brocher sad asd dsa "));
                tutorialItemModels.add(new TutorialItemModel(R.drawable.brochure,"HYPEROPIA_ACTIVTY X","Brocher sad asd dsa "));
                Render();
                break;
        }
    }

    public void Render()
    {
        adapter = new TutorialItemsAdapter(tutorialItemModels,this);
        viewPager = findViewById(R.id.viePager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(130,0,130,0);

        Integer[]  colors_temp = {
                getResources().getColor(R.color.color0),
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color3),
                getResources().getColor(R.color.color4),
                getResources().getColor(R.color.color5),
                getResources().getColor(R.color.color6),
        };

        colours = colors_temp;


        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


                // clear FLAG_TRANSLUCENT_STATUS flag:
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

                // add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

                if(position < (adapter.getCount()-1) && position < (colours.length-1)){
                    viewPager.setBackgroundColor(
                            (Integer) argbEvaluator.evaluate(
                                    positionOffset,
                                    colours[position],
                                    colours[position + 1]
                            ));
                    window.setStatusBarColor(
                            (Integer) argbEvaluator.evaluate(
                                    positionOffset,
                                    colours[position],
                                    colours[position + 1]
                            )
                    );

                }else {
                    viewPager.setBackgroundColor(colours[colours.length -1]);
                    window.setStatusBarColor(colours[colours.length -1]);
                }
            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }


    @Override
    public void onClick(View v) {
        Intent intent ;
        switch (v.getId()){
            case R.id.buttonStartTest:

                switch (ViewPageInt){

                    case Config.MYOPIA_ACTIVTY:
                        intent = new Intent(this,TesMyopiaActivity.class);
                        startActivity(intent);
                        break;

                        case Config.HYPEROPIA_ACTIVTY:
                            intent = new Intent(this,TesHyperpiaActivity.class);
                            startActivity(intent);
                            break;
                }

                break;

                default:

                    break;
        }
    }
}
