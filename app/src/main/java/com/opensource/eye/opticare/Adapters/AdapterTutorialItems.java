package com.opensource.eye.opticare.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.opensource.eye.opticare.Models.ModelTutorialItem;
import com.opensource.eye.opticare.R;

import java.util.List;

public class AdapterTutorialItems extends PagerAdapter {

    private List<ModelTutorialItem> models;
    private LayoutInflater layoutInflater;
    private Context context;

    public AdapterTutorialItems(List<ModelTutorialItem> models, Context context){
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
        View view = layoutInflater.inflate(R.layout.tutorial_item,container,false);

        container.addView(view,0);

        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
