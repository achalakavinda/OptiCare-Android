package com.opensource.eye.opticare.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.opensource.eye.opticare.Models.TestHyperpiaItemModel;
import com.opensource.eye.opticare.Models.TutorialItemModel;
import com.opensource.eye.opticare.R;

import java.util.List;

public class TestHyperpiaItemAdapter extends PagerAdapter {

    private List<TestHyperpiaItemModel> models;
    private LayoutInflater layoutInflater;
    private Context context;

    public TestHyperpiaItemAdapter(List<TestHyperpiaItemModel> models, Context context){
        this.models = models;
        this.context = context;
    }

    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view.equals(o);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int postion){
        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.test_hyperpia_item,container,false);
        container.addView(view,0);

        TextView ANSWER, Constant, Title;
        EditText inputField;

        Title = view.findViewById(R.id.Title);
        ANSWER = view.findViewById(R.id.ANSWER);
        Constant = view.findViewById(R.id.CONSTANT);
        inputField = view.findViewById(R.id.inputField);

        Title.setText(models.get(postion).getTtile());

        inputField.setText(models.get(postion).getAnswer().toUpperCase());
        ANSWER .setText(models.get(postion).getAnswer());

        Constant.setText(models.get(postion).getConstant());


        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
