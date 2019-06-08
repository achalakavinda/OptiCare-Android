package com.opensource.eye.opticare.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.opensource.eye.opticare.Models.TutorialItemModel;
import com.opensource.eye.opticare.R;

import java.util.List;

public class TutorialItemsAdapter extends PagerAdapter {

    private List<TutorialItemModel> models;
    private LayoutInflater layoutInflater;
    private Context context;

    public TutorialItemsAdapter(List<TutorialItemModel> models, Context context){
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

        ImageView imageView;
        TextView textViewTitle, textViewDesc;
        imageView = view.findViewById(R.id.image);

        textViewTitle = view.findViewById(R.id.title);
        textViewDesc = view.findViewById(R.id.desc);

        textViewTitle.setText(models.get(postion).getTitile());
        textViewDesc.setText(models.get(postion).getDesc());
        imageView.setImageDrawable(models.get(postion).getImage());

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }


}
