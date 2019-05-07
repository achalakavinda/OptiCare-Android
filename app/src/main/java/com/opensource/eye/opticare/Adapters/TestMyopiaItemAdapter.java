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
import com.opensource.eye.opticare.Models.TestMyopiaItemModel;
import com.opensource.eye.opticare.R;

import java.util.List;

public class TestMyopiaItemAdapter extends PagerAdapter {

    private List<TestMyopiaItemModel> models;
    private LayoutInflater layoutInflater;
    private Context context;

    public TestMyopiaItemAdapter(List<TestMyopiaItemModel> models, Context context){
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
        View view = layoutInflater.inflate(R.layout.test_myopia_item,container,false);
        container.addView(view,0);

        ImageView imageView;
        TextView textViewTitle, textViewDesc;
        EditText inputField;

        textViewTitle = view.findViewById(R.id.title);
        textViewDesc = view.findViewById(R.id.desc);
        imageView = view.findViewById(R.id.image);
        inputField = view.findViewById(R.id.inputField);


       imageView.setImageDrawable(models.get(postion).getImage());

        textViewTitle.setText(models.get(postion).getTitile());
        textViewDesc.setText(models.get(postion).getDesc());

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
