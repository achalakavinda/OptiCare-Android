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
import com.opensource.eye.opticare.Adapters.TestHyperpiaItemAdapter;
import com.opensource.eye.opticare.Adapters.TutorialItemsAdapter;
import com.opensource.eye.opticare.Models.TestHyperpiaItemModel;
import com.opensource.eye.opticare.Models.TutorialItemModel;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import Services.HttpRequest;

public class TesHyperpiaActivity extends AppCompatActivity implements View.OnClickListener {

    int MutePostionAt = -9;

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

    private Button buttonSubmit;

    //array objects
    private JsonObject ResultObjects;

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

        buttonSubmit = findViewById(R.id.Submit);
        buttonSubmit.setOnClickListener(this);

        testHyperpiaItemModels = new ArrayList<>();

        initiateHyperpiaTestObjects();
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
    private void CreateJSonArray()
    {

        JSONObject request = new JSONObject();
        JsonArray jsonElements = new JsonArray();

        for ( TestHyperpiaItemModel testHyperpiaItemModel : testHyperpiaItemModels)
        {
            System.out.println(String.valueOf(testHyperpiaItemModels.indexOf(testHyperpiaItemModel)+1)
                    + " Constant : "+ testHyperpiaItemModel.getConstant()
                    + " Answer : "+ testHyperpiaItemModel.getAnswer()
                    + " Result : "+ testHyperpiaItemModel.getaBoolean()
            );

            ResultObjects = new JsonObject();
            ResultObjects.addProperty("patient_id",1);
            ResultObjects.addProperty("optician_id",3);
            ResultObjects.addProperty("Constant",testHyperpiaItemModel.getConstant());
            ResultObjects.addProperty("Answer",testHyperpiaItemModel.getAnswer());
            ResultObjects.addProperty("Result",testHyperpiaItemModel.getaBoolean());
            ResultObjects.addProperty("Point",1);
            jsonElements.add(ResultObjects);
        }

        try
        {
            request.put("Data", jsonElements);
            RequestQueue queue = Volley.newRequestQueue(this);
            JsonObjectRequest jobReq = new JsonObjectRequest(Request.Method.POST, new HttpRequest().getUri()+"/test/hyperpia", request,
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
    private void initiateHyperpiaTestObjects()
    {
        testHyperpiaItemModels.add(new TestHyperpiaItemModel("sn_1_1","E","Test title"));

        testHyperpiaItemModels.add(new TestHyperpiaItemModel("sn_2_1","F","Test Description"));
        testHyperpiaItemModels.add(new TestHyperpiaItemModel("sn_2_2","P","Test Description"));

        testHyperpiaItemModels.add(new TestHyperpiaItemModel("sn_3_1","T","Test Description"));
        testHyperpiaItemModels.add(new TestHyperpiaItemModel("sn_3_2","0","Test Description"));
        testHyperpiaItemModels.add(new TestHyperpiaItemModel("sn_3_3","Z","Test Description"));

        testHyperpiaItemModels.add(new TestHyperpiaItemModel("sn_4_1","L","Test Description"));
        testHyperpiaItemModels.add(new TestHyperpiaItemModel("sn_4_2","P","Test Description"));
        testHyperpiaItemModels.add(new TestHyperpiaItemModel("sn_4_3","E","Test Description"));
        testHyperpiaItemModels.add(new TestHyperpiaItemModel("sn_4_4","D","Test Description"));

        testHyperpiaItemModels.add(new TestHyperpiaItemModel("sn_5_1","P","Test Description"));
        testHyperpiaItemModels.add(new TestHyperpiaItemModel("sn_5_2","E","Test Description"));
        testHyperpiaItemModels.add(new TestHyperpiaItemModel("sn_5_3","C","Test Description"));
        testHyperpiaItemModels.add(new TestHyperpiaItemModel("sn_5_4","F","Test Description"));
        testHyperpiaItemModels.add(new TestHyperpiaItemModel("sn_5_5","D","Test Description"));

        testHyperpiaItemModels.add(new TestHyperpiaItemModel("sn_6_1","E","Test Description"));
        testHyperpiaItemModels.add(new TestHyperpiaItemModel("sn_6_2","D","Test Description"));
        testHyperpiaItemModels.add(new TestHyperpiaItemModel("sn_6_3","F","Test Description"));
        testHyperpiaItemModels.add(new TestHyperpiaItemModel("sn_6_4","E","Test Description"));
        testHyperpiaItemModels.add(new TestHyperpiaItemModel("sn_6_5","Z","Test Description"));
        testHyperpiaItemModels.add(new TestHyperpiaItemModel("sn_6_6","P","Test Description"));

        testHyperpiaItemModels.add(new TestHyperpiaItemModel("sn_7_1","F","Test Description"));
        testHyperpiaItemModels.add(new TestHyperpiaItemModel("sn_7_2","E","Test Description"));
        testHyperpiaItemModels.add(new TestHyperpiaItemModel("sn_7_3","L","Test Description"));
        testHyperpiaItemModels.add(new TestHyperpiaItemModel("sn_7_4","O","Test Description"));
        testHyperpiaItemModels.add(new TestHyperpiaItemModel("sn_7_5","P","Test Description"));
        testHyperpiaItemModels.add(new TestHyperpiaItemModel("sn_7_6","Z","Test Description"));
        testHyperpiaItemModels.add(new TestHyperpiaItemModel("sn_7_7","D","Test Description"));

        testHyperpiaItemModels.add(new TestHyperpiaItemModel("sn_8_1","D","Test Description"));
        testHyperpiaItemModels.add(new TestHyperpiaItemModel("sn_8_2","E","Test Description"));
        testHyperpiaItemModels.add(new TestHyperpiaItemModel("sn_8_3","F","Test Description"));
        testHyperpiaItemModels.add(new TestHyperpiaItemModel("sn_8_4","P","Test Description"));
        testHyperpiaItemModels.add(new TestHyperpiaItemModel("sn_8_5","O","Test Description"));
        testHyperpiaItemModels.add(new TestHyperpiaItemModel("sn_8_6","T","Test Description"));
        testHyperpiaItemModels.add(new TestHyperpiaItemModel("sn_8_7","E","Test Description"));
        testHyperpiaItemModels.add(new TestHyperpiaItemModel("sn_8_8","C","Test Description"));
    }

    /**
     * Render test card into the recycle view
     */
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



                if( MutePostionAt != position )
                {
                    readAllPages();
                }

                MutePostionAt = position;

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

            for ( TestHyperpiaItemModel testHyperpiaItemModel : testHyperpiaItemModels)
            {
                if( testHyperpiaItemModel.getConstant().equals( Constant.getText().toString() ) )
                {
                    if(e.getText().toString().toUpperCase().equals( stringAnwer.toUpperCase() ))
                    {
                        System.out.println("True");
                        testHyperpiaItemModel.setaBoolean(true);
                    }else{

                        System.out.println("False");
                        testHyperpiaItemModel.setaBoolean(false);
                    }

                    testHyperpiaItemModels.set(testHyperpiaItemModels.indexOf(testHyperpiaItemModel),testHyperpiaItemModel);
                }

            }

        }
    }

}
