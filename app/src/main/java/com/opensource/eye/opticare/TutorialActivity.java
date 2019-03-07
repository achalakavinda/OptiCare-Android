package com.opensource.eye.opticare;

import android.animation.ArgbEvaluator;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.opensource.eye.opticare.Adapters.TutorialItemsAdapter;
import com.opensource.eye.opticare.Models.TutorialItemModel;

import java.util.ArrayList;
import java.util.List;

public class TutorialActivity extends AppCompatActivity implements View .OnClickListener{

    ViewPager viewPager;
    TutorialItemsAdapter adapter;
    List<TutorialItemModel> tutorialItemModels;
    Integer[]  colours = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();

    Window window = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        window = getWindow();

        tutorialItemModels = new ArrayList<>();
        tutorialItemModels.add(new TutorialItemModel(R.drawable.brochure,"Brochure","Brocher"));
        tutorialItemModels.add(new TutorialItemModel(R.drawable.brochure,"Brochure X","Brocher sad asd dsa "));
        tutorialItemModels.add(new TutorialItemModel(R.drawable.brochure,"Brochure X","Brocher sad asd dsa "));
        tutorialItemModels.add(new TutorialItemModel(R.drawable.brochure,"Brochure X","Brocher sad asd dsa "));
        tutorialItemModels.add(new TutorialItemModel(R.drawable.brochure,"Brochure X","Brocher sad asd dsa "));
        tutorialItemModels.add(new TutorialItemModel(R.drawable.brochure,"Brochure X","Brocher sad asd dsa "));

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
        switch (v.getId()){
            case R.id.buttonStartTest:

                break;
                default:

                    break;
        }
    }
}
