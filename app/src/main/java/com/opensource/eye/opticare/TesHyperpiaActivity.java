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
import com.opensource.eye.opticare.Adapters.TutorialItemsAdapter;
import com.opensource.eye.opticare.Models.TestHyperpiaItemModel;
import com.opensource.eye.opticare.Models.TutorialItemModel;

import java.util.ArrayList;
import java.util.List;

public class TesHyperpiaActivity extends AppCompatActivity {

    RelativeLayout relativeLayoutATH;
    ViewPager viewPager;
    TestHyperpiaItemAdapter adapter;
    List<TestHyperpiaItemModel> testHyperpiaItemModels;
    Integer[]  colours = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();
    Window window = null;

    //main text views
    private TextView questionText;
    private TextView countText;
    private TextView distanceText;

    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tes_hyperpia);

        relativeLayoutATH = findViewById(R.id.ATH);
        window = getWindow();

        questionText = findViewById(R.id.questionText);
        countText = findViewById(R.id.countText);
        distanceText = findViewById(R.id.distanceText);
        distanceText.setText("20 Feet");

        testHyperpiaItemModels = new ArrayList<>();
        testHyperpiaItemModels.add(new TestHyperpiaItemModel(R.drawable.brochure,"Read and Enter","Please Read the first letter."));
        testHyperpiaItemModels.add(new TestHyperpiaItemModel(R.drawable.brochure,"Read and Enter","Please Read the first letter."));
        testHyperpiaItemModels.add(new TestHyperpiaItemModel(R.drawable.brochure,"Read and Enter","Please Read the first letter."));
        testHyperpiaItemModels.add(new TestHyperpiaItemModel(R.drawable.brochure,"Read and Enter","Please Read the first letter."));
        testHyperpiaItemModels.add(new TestHyperpiaItemModel(R.drawable.brochure,"Read and Enter","Please Read the first letter."));
        testHyperpiaItemModels.add(new TestHyperpiaItemModel(R.drawable.brochure,"Read and Enter","Please Read the first letter."));
        Render();
    }


    public void Render()
    {
        adapter = new TestHyperpiaItemAdapter(testHyperpiaItemModels,this);
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
                    relativeLayoutATH.setBackgroundColor(
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
                    relativeLayoutATH.setBackgroundColor(colours[colours.length -1]);
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
