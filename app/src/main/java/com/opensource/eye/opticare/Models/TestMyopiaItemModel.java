package com.opensource.eye.opticare.Models;

import android.graphics.drawable.Drawable;

public class TestMyopiaItemModel {

    private Drawable image;
    private String titile;
    private String desc;

    private String constant;
    private String answer;
    private Boolean aBoolean;

    public TestMyopiaItemModel(String constant, String answer ,Drawable image, String titile, String desc)
    {
        this.constant = constant;
        this.answer = answer;
        this.image = image;
        this.titile = titile;
        this.desc = desc;
    }

    public Drawable getImage()
    {
        return image;
    }

    public void setImage(Drawable image)
    {
        this.image = image;
    }

    public String getTitile()
    {
        return titile;
    }

    public void setTitile(String titile)
    {
        this.titile = titile;
    }

    public String getDesc()
    {
        return desc;
    }

    public void setDesc(String desc)
    {
        this.desc = desc;
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
