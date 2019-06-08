package com.opensource.eye.opticare.Models;

import android.graphics.drawable.Drawable;

public class TutorialItemModel {

    private Drawable image;
    private String titile;
    private String desc;

    public TutorialItemModel(Drawable image, String titile, String desc) {
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
}
