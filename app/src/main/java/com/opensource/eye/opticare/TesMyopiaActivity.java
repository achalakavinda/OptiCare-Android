package com.opensource.eye.opticare;

import android.animation.ArgbEvaluator;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.opensource.eye.opticare.Adapters.TestHyperpiaItemAdapter;
import com.opensource.eye.opticare.Adapters.TestMyopiaItemAdapter;
import com.opensource.eye.opticare.Models.TestHyperpiaItemModel;
import com.opensource.eye.opticare.Models.TestMyopiaItemModel;

import java.util.ArrayList;
import java.util.List;

public class TesMyopiaActivity extends AppCompatActivity {

    RelativeLayout relativeLayoutATM;
    ViewPager viewPager;
    TestMyopiaItemAdapter adapter;
    List<TestMyopiaItemModel> testMyopiaItemModels;
    Integer[]  colours = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();
    Window window = null;

    //main text views
    private TextView questionText;
    private TextView countText;
    private TextView distanceText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tes_myopia);

        relativeLayoutATM = findViewById(R.id.ATM);
        window = getWindow();

        questionText = findViewById(R.id.questionText);
        countText = findViewById(R.id.countText);
        distanceText = findViewById(R.id.distanceText);
        distanceText.setText("");

        testMyopiaItemModels =  new ArrayList<>();
        testMyopiaItemModels.add(new TestMyopiaItemModel(R.drawable.brochure,"Test title","Test Description",200,90));
        testMyopiaItemModels.add(new TestMyopiaItemModel(R.drawable.brochure,"Test title","Test Description",180,80));
        testMyopiaItemModels.add(new TestMyopiaItemModel(R.drawable.brochure,"Test title","Test Description",150,70));
        testMyopiaItemModels.add(new TestMyopiaItemModel(R.drawable.brochure,"Test title","Test Description",120,60));

        Render();
    }


    public void Render()
    {
        adapter = new TestMyopiaItemAdapter(testMyopiaItemModels,this);
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

                countText.setText("Count\t:\t"+String.valueOf(position));

                if(position < (adapter.getCount()-1) && position < (colours.length-1)){
                    relativeLayoutATM.setBackgroundColor(
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
                    relativeLayoutATM.setBackgroundColor(colours[colours.length -1]);
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


}
