package com.opensource.eye.opticare.Models;

public class TestMyopiaItemModel {

    private int image;
    private String titile;
    private String desc;
    private int imageHeight;
    private int imageWeight;


    public TestMyopiaItemModel(int image, String titile, String desc,int imageHeight, int imageWeight) {
        this.image = image;
        this.titile = titile;
        this.desc = desc;
        this.imageHeight =  imageHeight;
        this.imageWeight = imageWeight;
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
}
