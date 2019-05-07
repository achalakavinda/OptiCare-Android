package com.opensource.eye.opticare.Models;

import android.graphics.drawable.Drawable;

public class TestMyopiaItemModel {

    private Drawable image;
    private String titile;
    private String desc;
    private int imageHeight;
    private int imageWeight;

    private String constant;
    private String answer;
    private Boolean aBoolean;


    public TestMyopiaItemModel(String constant, String answer ,Drawable image, String titile, String desc,int imageHeight, int imageWeight) {
        this.constant = constant;
        this.answer = answer;
        this.image = image;
        this.titile = titile;
        this.desc = desc;
        this.imageHeight =  imageHeight;
        this.imageWeight = imageWeight;
    }

    public TestMyopiaItemModel(String constant, String answer ,Drawable image, String titile, String desc) {
        this.constant = constant;
        this.answer = answer;
        this.image = image;
        this.titile = titile;
        this.desc = desc;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    public String getTitile() {
        return titile;
    }

    public void setTitile(String titile) {
        this.titile = titile;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getImageHeight() {
        return imageHeight;
    }

    public void setImageHeight(int imageHeight) {
        this.imageHeight = imageHeight;
    }

    public int getImageWeight() {
        return imageWeight;
    }

    public void setImageWeight(int imageWeight) {
        this.imageWeight = imageWeight;
    }

    public String getConstant() { return constant; }

    public void setConstant(String constant) { this.constant = constant; }

    public String getAnswer() { return answer; }

    public void setAnswer(String answer) { this.answer = answer; }

    public Boolean getaBoolean() { return aBoolean; }
    public void setaBoolean(Boolean aBoolean) { this.aBoolean = aBoolean; }

}
