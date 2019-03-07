package com.opensource.eye.opticare.Models;

public class TutorialItemModel {

    private int image;
    private String titile;
    private String desc;

    public TutorialItemModel(int image, String titile, String desc) {
        this.image = image;
        this.titile = titile;
        this.desc = desc;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
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
