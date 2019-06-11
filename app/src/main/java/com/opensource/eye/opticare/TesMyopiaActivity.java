package com.opensource.eye.opticare;

import android.animation.ArgbEvaluator;
import android.content.Intent;
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

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.opensource.eye.opticare.Adapters.TestMyopiaItemAdapter;
import com.opensource.eye.opticare.Models.TestMyopiaItemModel;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Models.UserStatic;
import Services.HttpRequest;

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
    private JsonObject ResultObjects;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tes_myopia);

        relativeLayoutATM = findViewById(R.id.ATM);
        window = getWindow();

        questionText = findViewById(R.id.questionText);
        countText = findViewById(R.id.countText);
        distanceText = findViewById(R.id.distanceText);
        distanceText.setText("");

        buttonSubmit = findViewById(R.id.Submit);
        buttonSubmit.setOnClickListener(this);


        testMyopiaItemModels =  new ArrayList<>();

        initiateMyopiaTestObjects();
        Render();
    }

    /**
     * Onclick Listener for the all view click events
     * @param v
     */
    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.Submit:
                CreateJSonArray();
                break;
                default:
                    System.out.println("do nothing");

        }
    }

    /**
     * Create a Json array and post into backend with all result
     */
    private void CreateJSonArray(){
        JSONObject request = new JSONObject();
        JsonArray jsonElements = new JsonArray();

        for ( TestMyopiaItemModel testMyopiaItemModel : testMyopiaItemModels)
        {
            System.out.println(String.valueOf(testMyopiaItemModels.indexOf(testMyopiaItemModel)+1)
                    + " Constant : "+ testMyopiaItemModel.getConstant()
                    + " Answer : "+ testMyopiaItemModel.getAnswer()
                    + " Result : "+ testMyopiaItemModel.getaBoolean()
            );

            ResultObjects = new JsonObject();
            ResultObjects.addProperty("patient_id", UserStatic.getUserId());
            ResultObjects.addProperty("optician_id",UserStatic.getOptician_id());
            ResultObjects.addProperty("Constant",testMyopiaItemModel.getConstant());
            ResultObjects.addProperty("Answer",testMyopiaItemModel.getAnswer());
            ResultObjects.addProperty("Result",testMyopiaItemModel.getaBoolean());
            ResultObjects.addProperty("Point",1);
            jsonElements.add(ResultObjects);
        }

        try
        {
            request.put("Data", jsonElements);
            RequestQueue queue = Volley.newRequestQueue(this);
            JsonObjectRequest jobReq = new JsonObjectRequest(Request.Method.POST, new HttpRequest().getUri()+"/test/myopia", request,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject jsonObject) {
                            System.out.println(jsonObject.toString());
                            Intent intent = new Intent(getApplicationContext(),ScoreActivity.class);
                            startActivity(intent);
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError volleyError) {
                            System.out.println(volleyError.getMessage());
                        }
                    });

            queue.add(jobReq);

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }

    /**
     * Add test objects into the Object array list
     */
    private void initiateMyopiaTestObjects(){

        testMyopiaItemModels.add(new TestMyopiaItemModel("sn_1_1",0,"E",this.getResources().getDrawable(R.drawable.sn_1_1),"Test title","Test Description"));

        testMyopiaItemModels.add(new TestMyopiaItemModel("sn_2_1",0,"F",this.getResources().getDrawable(R.drawable.sn_2_1),"Test title","Test Description"));
        testMyopiaItemModels.add(new TestMyopiaItemModel("sn_2_2",1,"P",this.getResources().getDrawable(R.drawable.sn_2_2),"Test title","Test Description"));

        testMyopiaItemModels.add(new TestMyopiaItemModel("sn_3_1",1,"T",this.getResources().getDrawable(R.drawable.sn_3_1),"Test title","Test Description"));
        testMyopiaItemModels.add(new TestMyopiaItemModel("sn_3_2",2,"0",this.getResources().getDrawable(R.drawable.sn_3_2),"Test title","Test Description"));
        testMyopiaItemModels.add(new TestMyopiaItemModel("sn_3_3",2,"Z",this.getResources().getDrawable(R.drawable.sn_3_3),"Test title","Test Description"));

        testMyopiaItemModels.add(new TestMyopiaItemModel("sn_4_1",0,"L",this.getResources().getDrawable(R.drawable.sn_4_1),"Test title","Test Description"));
        testMyopiaItemModels.add(new TestMyopiaItemModel("sn_4_2",0,"P",this.getResources().getDrawable(R.drawable.sn_4_2),"Test title","Test Description"));
        testMyopiaItemModels.add(new TestMyopiaItemModel("sn_4_3",0,"E",this.getResources().getDrawable(R.drawable.sn_4_3),"Test title","Test Description"));
        testMyopiaItemModels.add(new TestMyopiaItemModel("sn_4_4",0,"D",this.getResources().getDrawable(R.drawable.sn_4_4),"Test title","Test Description"));

        testMyopiaItemModels.add(new TestMyopiaItemModel("sn_5_1",0,"P",this.getResources().getDrawable(R.drawable.sn_5_1),"Test title","Test Description"));
        testMyopiaItemModels.add(new TestMyopiaItemModel("sn_5_2",0,"E",this.getResources().getDrawable(R.drawable.sn_5_2),"Test title","Test Description"));
        testMyopiaItemModels.add(new TestMyopiaItemModel("sn_5_3",0,"C",this.getResources().getDrawable(R.drawable.sn_5_3),"Test title","Test Description"));
        testMyopiaItemModels.add(new TestMyopiaItemModel("sn_5_4",0,"F",this.getResources().getDrawable(R.drawable.sn_5_4),"Test title","Test Description"));
        testMyopiaItemModels.add(new TestMyopiaItemModel("sn_5_5",0,"D",this.getResources().getDrawable(R.drawable.sn_5_5),"Test title","Test Description"));

        testMyopiaItemModels.add(new TestMyopiaItemModel("sn_6_1",0,"E",this.getResources().getDrawable(R.drawable.sn_6_1),"Test title","Test Description"));
        testMyopiaItemModels.add(new TestMyopiaItemModel("sn_6_2",0,"D",this.getResources().getDrawable(R.drawable.sn_6_2),"Test title","Test Description"));
        testMyopiaItemModels.add(new TestMyopiaItemModel("sn_6_3",0,"F",this.getResources().getDrawable(R.drawable.sn_6_3),"Test title","Test Description"));
        testMyopiaItemModels.add(new TestMyopiaItemModel("sn_6_4",0,"E",this.getResources().getDrawable(R.drawable.sn_6_4),"Test title","Test Description"));
        testMyopiaItemModels.add(new TestMyopiaItemModel("sn_6_5",0,"Z",this.getResources().getDrawable(R.drawable.sn_6_5),"Test title","Test Description"));
        testMyopiaItemModels.add(new TestMyopiaItemModel("sn_6_6",0,"P",this.getResources().getDrawable(R.drawable.sn_6_6),"Test title","Test Description"));

        testMyopiaItemModels.add(new TestMyopiaItemModel("sn_7_1",0,"F",this.getResources().getDrawable(R.drawable.sn_7_1),"Test title","Test Description"));
        testMyopiaItemModels.add(new TestMyopiaItemModel("sn_7_2",0,"E",this.getResources().getDrawable(R.drawable.sn_7_2),"Test title","Test Description"));
        testMyopiaItemModels.add(new TestMyopiaItemModel("sn_7_3",0,"L",this.getResources().getDrawable(R.drawable.sn_7_3),"Test title","Test Description"));
        testMyopiaItemModels.add(new TestMyopiaItemModel("sn_7_4",0,"O",this.getResources().getDrawable(R.drawable.sn_7_4),"Test title","Test Description"));
        testMyopiaItemModels.add(new TestMyopiaItemModel("sn_7_5",0,"P",this.getResources().getDrawable(R.drawable.sn_7_5),"Test title","Test Description"));
        testMyopiaItemModels.add(new TestMyopiaItemModel("sn_7_6",0,"Z",this.getResources().getDrawable(R.drawable.sn_7_6),"Test title","Test Description"));
        testMyopiaItemModels.add(new TestMyopiaItemModel("sn_7_7",0,"D",this.getResources().getDrawable(R.drawable.sn_7_7),"Test title","Test Description"));

        testMyopiaItemModels.add(new TestMyopiaItemModel("sn_8_1",0,"D",this.getResources().getDrawable(R.drawable.sn_8_1),"Test title","Test Description"));
        testMyopiaItemModels.add(new TestMyopiaItemModel("sn_8_2",0,"E",this.getResources().getDrawable(R.drawable.sn_8_2),"Test title","Test Description"));
        testMyopiaItemModels.add(new TestMyopiaItemModel("sn_8_3",0,"F",this.getResources().getDrawable(R.drawable.sn_8_3),"Test title","Test Description"));
        testMyopiaItemModels.add(new TestMyopiaItemModel("sn_8_4",0,"P",this.getResources().getDrawable(R.drawable.sn_8_4),"Test title","Test Description"));
        testMyopiaItemModels.add(new TestMyopiaItemModel("sn_8_5",0,"O",this.getResources().getDrawable(R.drawable.sn_8_5),"Test title","Test Description"));
        testMyopiaItemModels.add(new TestMyopiaItemModel("sn_8_6",0,"T",this.getResources().getDrawable(R.drawable.sn_8_6),"Test title","Test Description"));
        testMyopiaItemModels.add(new TestMyopiaItemModel("sn_8_7",0,"E",this.getResources().getDrawable(R.drawable.sn_8_7),"Test title","Test Description"));
        testMyopiaItemModels.add(new TestMyopiaItemModel("sn_8_8",0,"C",this.getResources().getDrawable(R.drawable.sn_8_8),"Test title","Test Description"));

    }

    /**
     * Render test card into the recycle view
     */
    private void Render()
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

                if( position == 35 ){
                    buttonSubmit.setVisibility(View.VISIBLE);
                }else {
                    System.out.println("do nothing");
                }

                if( MutePostionAt != position )
                {
                    readAllPages();
                }

                MutePostionAt = position;

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


    /**
     * Read All List Object and update with results
     */
    private void readAllPages()
    {
        for (int i = 0; i < viewPager.getChildCount(); i++)
        {
            View v = viewPager.getChildAt(i);

            EditText e = (EditText) v.findViewById(R.id.inputField);
            TextView Constant = (TextView) v.findViewById(R.id.CONSTANT);
            TextView Answer = (TextView) v.findViewById(R.id.ANSWER);

            String stringAnwer = (String) Answer.getText();

            System.out.println( e.getText()+" = "+ stringAnwer );

            for ( TestMyopiaItemModel testMyopiaItemModel : testMyopiaItemModels)
            {

                if( testMyopiaItemModel.getConstant().toString().equals(Constant.getText().toString()) ){

                    if(e.getText().toString().toUpperCase().equals(stringAnwer.toString().toUpperCase())){
                        System.out.println("True");
                        testMyopiaItemModel.setaBoolean(true);
                    }else{
                        System.out.println("False");
                        testMyopiaItemModel.setaBoolean(false);
                    }

                    testMyopiaItemModels.set(testMyopiaItemModels.indexOf(testMyopiaItemModel),testMyopiaItemModel);

                }
            }

        }
    }



}
