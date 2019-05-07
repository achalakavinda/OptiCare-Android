package com.opensource.eye.opticare;

import android.animation.ArgbEvaluator;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.opensource.eye.opticare.Adapters.TestMyopiaItemAdapter;
import com.opensource.eye.opticare.Models.TestMyopiaItemModel;

import java.util.ArrayList;
import java.util.List;

public class TesMyopiaActivity extends AppCompatActivity implements View.OnClickListener {

    int MutePostionAt = -9;

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

    private Button buttonSubmit;

    //array objects
    private JsonArray postArray;
    private JsonObject ResultObjects;


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

        buttonSubmit = findViewById(R.id.Submit);
        buttonSubmit.setVisibility(View.INVISIBLE);
        buttonSubmit.setOnClickListener(this);

        //initiate array list
        testMyopiaItemModels =  new ArrayList<>();
        postArray = new JsonArray();
        ResultObjects = new JsonObject();

        ResultObjects.addProperty("const","SN_0_0");
        ResultObjects.addProperty("Answer","E");
        ResultObjects.addProperty("Answered",true);

        testMyopiaItemModels.add(new TestMyopiaItemModel("sn_1_1","E",this.getResources().getDrawable(R.drawable.sn_1_1),"Test title","Test Description"));

        testMyopiaItemModels.add(new TestMyopiaItemModel("sn_2_1","F",this.getResources().getDrawable(R.drawable.sn_2_1),"Test title","Test Description"));
        testMyopiaItemModels.add(new TestMyopiaItemModel("sn_2_2","F",this.getResources().getDrawable(R.drawable.sn_2_2),"Test title","Test Description"));

        testMyopiaItemModels.add(new TestMyopiaItemModel("sn_3_1","F",this.getResources().getDrawable(R.drawable.sn_3_1),"Test title","Test Description"));
        testMyopiaItemModels.add(new TestMyopiaItemModel("sn_3_2","F",this.getResources().getDrawable(R.drawable.sn_3_2),"Test title","Test Description"));
        testMyopiaItemModels.add(new TestMyopiaItemModel("sn_3_3","F",this.getResources().getDrawable(R.drawable.sn_3_3),"Test title","Test Description"));

        testMyopiaItemModels.add(new TestMyopiaItemModel("sn_4_1","F",this.getResources().getDrawable(R.drawable.sn_4_1),"Test title","Test Description"));
        testMyopiaItemModels.add(new TestMyopiaItemModel("sn_4_2","F",this.getResources().getDrawable(R.drawable.sn_4_2),"Test title","Test Description"));
        testMyopiaItemModels.add(new TestMyopiaItemModel("sn_4_3","F",this.getResources().getDrawable(R.drawable.sn_4_3),"Test title","Test Description"));
        testMyopiaItemModels.add(new TestMyopiaItemModel("sn_4_4","F",this.getResources().getDrawable(R.drawable.sn_4_4),"Test title","Test Description"));

        testMyopiaItemModels.add(new TestMyopiaItemModel("sn_5_1","F",this.getResources().getDrawable(R.drawable.sn_5_1),"Test title","Test Description"));
        testMyopiaItemModels.add(new TestMyopiaItemModel("sn_5_2","F",this.getResources().getDrawable(R.drawable.sn_5_2),"Test title","Test Description"));
        testMyopiaItemModels.add(new TestMyopiaItemModel("sn_5_3","F",this.getResources().getDrawable(R.drawable.sn_5_3),"Test title","Test Description"));
        testMyopiaItemModels.add(new TestMyopiaItemModel("sn_5_4","F",this.getResources().getDrawable(R.drawable.sn_5_4),"Test title","Test Description"));
        testMyopiaItemModels.add(new TestMyopiaItemModel("sn_5_5","F",this.getResources().getDrawable(R.drawable.sn_5_5),"Test title","Test Description"));

        testMyopiaItemModels.add(new TestMyopiaItemModel("sn_6_1","F",this.getResources().getDrawable(R.drawable.sn_6_1),"Test title","Test Description"));
        testMyopiaItemModels.add(new TestMyopiaItemModel("sn_6_2","F",this.getResources().getDrawable(R.drawable.sn_6_2),"Test title","Test Description"));
        testMyopiaItemModels.add(new TestMyopiaItemModel("sn_6_3","F",this.getResources().getDrawable(R.drawable.sn_6_3),"Test title","Test Description"));
        testMyopiaItemModels.add(new TestMyopiaItemModel("sn_6_4","F",this.getResources().getDrawable(R.drawable.sn_6_4),"Test title","Test Description"));
        testMyopiaItemModels.add(new TestMyopiaItemModel("sn_6_5","F",this.getResources().getDrawable(R.drawable.sn_6_5),"Test title","Test Description"));
        testMyopiaItemModels.add(new TestMyopiaItemModel("sn_6_6","F",this.getResources().getDrawable(R.drawable.sn_6_6),"Test title","Test Description"));

        testMyopiaItemModels.add(new TestMyopiaItemModel("sn_7_1","F",this.getResources().getDrawable(R.drawable.sn_7_1),"Test title","Test Description"));
        testMyopiaItemModels.add(new TestMyopiaItemModel("sn_7_2","F",this.getResources().getDrawable(R.drawable.sn_7_2),"Test title","Test Description"));
        testMyopiaItemModels.add(new TestMyopiaItemModel("sn_7_3","F",this.getResources().getDrawable(R.drawable.sn_7_3),"Test title","Test Description"));
        testMyopiaItemModels.add(new TestMyopiaItemModel("sn_7_4","F",this.getResources().getDrawable(R.drawable.sn_7_4),"Test title","Test Description"));
        testMyopiaItemModels.add(new TestMyopiaItemModel("sn_7_5","F",this.getResources().getDrawable(R.drawable.sn_7_5),"Test title","Test Description"));
        testMyopiaItemModels.add(new TestMyopiaItemModel("sn_7_6","F",this.getResources().getDrawable(R.drawable.sn_7_6),"Test title","Test Description"));
        testMyopiaItemModels.add(new TestMyopiaItemModel("sn_7_7","F",this.getResources().getDrawable(R.drawable.sn_7_7),"Test title","Test Description"));

        testMyopiaItemModels.add(new TestMyopiaItemModel("sn_8_1","F",this.getResources().getDrawable(R.drawable.sn_8_1),"Test title","Test Description"));
        testMyopiaItemModels.add(new TestMyopiaItemModel("sn_8_2","F",this.getResources().getDrawable(R.drawable.sn_8_2),"Test title","Test Description"));
        testMyopiaItemModels.add(new TestMyopiaItemModel("sn_8_3","F",this.getResources().getDrawable(R.drawable.sn_8_3),"Test title","Test Description"));
        testMyopiaItemModels.add(new TestMyopiaItemModel("sn_8_4","F",this.getResources().getDrawable(R.drawable.sn_8_4),"Test title","Test Description"));
        testMyopiaItemModels.add(new TestMyopiaItemModel("sn_8_5","F",this.getResources().getDrawable(R.drawable.sn_8_5),"Test title","Test Description"));
        testMyopiaItemModels.add(new TestMyopiaItemModel("sn_8_6","F",this.getResources().getDrawable(R.drawable.sn_8_6),"Test title","Test Description"));
        testMyopiaItemModels.add(new TestMyopiaItemModel("sn_8_7","F",this.getResources().getDrawable(R.drawable.sn_8_7),"Test title","Test Description"));
        testMyopiaItemModels.add(new TestMyopiaItemModel("sn_8_8","F",this.getResources().getDrawable(R.drawable.sn_8_8),"Test title","Test Description"));


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

                if( position == 27 ){
                    buttonSubmit.setVisibility(View.VISIBLE);
                }else {
                    buttonSubmit.setVisibility(View.INVISIBLE);
                    System.out.println("do nothing");
                }

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

        viewPager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        readAllPages();
    }

    private void readAllPages(){
        for (int i = 0; i < viewPager.getChildCount(); i++) {
            View v = viewPager.getChildAt(i);
            EditText e = (EditText) v.findViewById(R.id.inputField);
            System.out.println(e.getText());
        }
    }


}
