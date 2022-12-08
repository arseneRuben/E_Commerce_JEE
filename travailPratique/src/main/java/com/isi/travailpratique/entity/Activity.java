package com.isi.travailpratique.entity;

public class Activity extends Entity  {
    private int activity_id;
    private int site_id;
    private String wording;
    private String image;
    private Float price;

    public int getSite_id() {
        return site_id;
    }

    public void setSite_id(int site_id) {
        this.site_id = site_id;
    }

    public String getWording() {
        return wording;
    }

    public void setWording(String wording) {
        this.wording = wording;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Activity(int site_id, String wording, String image, Float price) {
        this.activity_id=super.id;
        this.site_id = site_id;
        this.wording = wording;
        this.image = image;
        this.price = price;
    }

    public Activity() {

    }
}
