package com.opensource.eye.opticare.Models;

import android.graphics.drawable.Drawable;

public class TestHyperpiaItemModel {

    private String title;

    private String constant;
    private String answer;
    private Boolean aBoolean;

    public TestHyperpiaItemModel(String constant, String answer , String title)
    {
        this.constant = constant;
        this.answer = answer;
        this.title = title;
    }


    public String getTtile()
    {
        return title;
    }

    public void setTitle(String titile)
    {
        this.title = titile;
    }

    public String getConstant()
    {
        return constant;
    }

    public void setConstant(String constant)
    {
        this.constant = constant;
    }

    public String getAnswer()
    {
        return answer;
    }

    public void setAnswer(String answer)
    {
        this.answer = answer;
    }

    public Boolean getaBoolean()
    {
        return aBoolean;
    }

    public void setaBoolean(Boolean aBoolean)
    {
        this.aBoolean = aBoolean;
    }
}
