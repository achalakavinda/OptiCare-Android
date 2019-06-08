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
import com.opensource.eye.opticare.Models.TestAstigmatism;
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

                tutorialItemModels.add(new TutorialItemModel(getResources().getDrawable(R.drawable.brochure),"MYOPIA Test","If you notice that you cannot see well close-up or from a distance, then you probably suffer from defective vision"));
                tutorialItemModels.add(new TutorialItemModel(getResources().getDrawable(R.drawable.brochure),"MYOPIA Test","If you are short-sighted, you can see well close-up without spectacles, but in the distance everything is blurred and unclear. The most frequent cause is a longer eyeball (length myopia) meaning that the image emerges before the retina and therefore cannot be seen sharply."));
                tutorialItemModels.add(new TutorialItemModel(getResources().getDrawable(R.drawable.brochure),"MYOPIA Test","Test Your Vision"));
                tutorialItemModels.add(new TutorialItemModel(getResources().getDrawable(R.drawable.brochure),"MYOPIA Test","Position yourself approximately 1 metre from your mobile screen,"));
                tutorialItemModels.add(new TutorialItemModel(getResources().getDrawable(R.drawable.brochure),"MYOPIA Test","When you click \"Start\", you will be shown a latter. In the field below, type the letters as you seen, without spaces."));
                tutorialItemModels.add(new TutorialItemModel(getResources().getDrawable(R.drawable.brochure),"Important Note","A self-test does not replace the professional eye test with an optometrist or ophthalmologist."));
                Render();
                break;
            case Config.HYPEROPIA_ACTIVTY:

                tutorialItemModels.add(new TutorialItemModel(getResources().getDrawable(R.drawable.brochure),"HYPEROPIA Test","If you notice that you cannot see well close-up or from a distance, then you probably suffer from defective vision."));
                tutorialItemModels.add(new TutorialItemModel(getResources().getDrawable(R.drawable.brochure),"HYPEROPIA Test","Long-sightedness occurs in most cases from a shorter eyeball (length hyperopia). The image emerges behind the retina and is not shown sharply. For distance vision this can still be balanced relatively well for some time, but close-up vision is not clear."));
                tutorialItemModels.add(new TutorialItemModel(getResources().getDrawable(R.drawable.brochure),"HYPEROPIA Test","Test Your Vision"));
                tutorialItemModels.add(new TutorialItemModel(getResources().getDrawable(R.drawable.brochure),"HYPEROPIA Test","Secure the sheet on the wall at eye level and move back 4 metres (5 steps).\n"));
                tutorialItemModels.add(new TutorialItemModel(getResources().getDrawable(R.drawable.brochure),"HYPEROPIA Test","When you click \"Start\", you will be shown a line number. In the field below, type the letters as you seen in the relevant line, without spaces."));
                tutorialItemModels.add(new TutorialItemModel(getResources().getDrawable(R.drawable.brochure),"Important Note","A self-test does not replace the professional eye test with an optometrist or ophthalmologist."));
                Render();
                break;

            case Config.ASTIGMATISM_ACTIVTY:
                tutorialItemModels.add(new TutorialItemModel(getResources().getDrawable(R.drawable.astigmaticeye),"ASTIMATISM Test","Curved means that the cornea is not evenly shaped. Mild astigmatism is quite common."));
                tutorialItemModels.add(new TutorialItemModel(getResources().getDrawable(R.drawable.normalvs),"ASTIMATISM Test","Approx. 70% of all spectacle wearers are astigmatic. This means they have a corneal curvature."));
                tutorialItemModels.add(new TutorialItemModel(getResources().getDrawable(R.drawable.astigmatismview),"ASTIMATISM Test","The different deformations of the cornea mean that the light is refracted differently and as a result, for example, round objects appear oval due to the distortion. This also explains the synonym \"astigmatism\"."));
                tutorialItemModels.add(new TutorialItemModel(getResources().getDrawable(R.drawable.test),"ASTIMATISM Test","Test for corneal curvature"));
                tutorialItemModels.add(new TutorialItemModel(getResources().getDrawable(R.drawable.asti),"ASTIMATISM Test","Look at the circles one after the other and observe the lines"));
                tutorialItemModels.add(new TutorialItemModel(getResources().getDrawable(R.drawable.oneeye),"Important","Do this first with each eye, then with two eyes together. You can then do the test with or without spectacles."));
                tutorialItemModels.add(new TutorialItemModel(getResources().getDrawable(R.drawable.cornealcurvature),"Important","See clear, black lines in all circles ?"));
                tutorialItemModels.add(new TutorialItemModel(getResources().getDrawable(R.drawable.opt),"Results","If the lines appear blurred or unclear in one or several directions, this may indicate eye irregularities."));
                tutorialItemModels.add(new TutorialItemModel(getResources().getDrawable(R.drawable.opt),"Results","In this case you should visit your optician or ophthalmologist. If you also detect the differences of the lines with your spectacles, you should have your spectacles checked because an uncorrected astigmatism reduces your visual acuity."));
                tutorialItemModels.add(new TutorialItemModel(getResources().getDrawable(R.drawable.opt),"Important Note","A self-test does not replace the professional eye test with an optometrist or ophthalmologist."));

                Render();
                break;

            case Config.PRESBYOPIA_ACTIVTY:
                tutorialItemModels.add(new TutorialItemModel(getResources().getDrawable(R.drawable.presbyope),"Presbyopia Test","When your arms are too short to read: Presbyopia is the most frequent cause of defective vision as we get older."));
                tutorialItemModels.add(new TutorialItemModel(getResources().getDrawable(R.drawable.pres),"Presbyopia Test","Our eyesight in the near area deteriorates as we get older and books or letters have to be read with an extended arm. The ageing process of the eye and the accompanying decreasing elasticity of the eye lens are responsible.\n"));
                tutorialItemModels.add(new TutorialItemModel(getResources().getDrawable(R.drawable.test),"Presbyopia Test","Test for Presbyopia"));
                tutorialItemModels.add(new TutorialItemModel(getResources().getDrawable(R.drawable.test),"Presbyopia Test","Test"));
                tutorialItemModels.add(new TutorialItemModel(getResources().getDrawable(R.drawable.opt),"Important Note","A self-test does not replace the professional eye test with an optometrist or ophthalmologist."));

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

                        case Config.ASTIGMATISM_ACTIVTY:
                        intent = new Intent(this, TestAstigmatism.class);
                        startActivity(intent);
                        break;

                        case Config.PRESBYOPIA_ACTIVTY:
                        intent = new Intent(this,TestAstigmatism.class);
                        startActivity(intent);
                        break;


                }

                break;

                default:

                    break;
        }
    }
}
