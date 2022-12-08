package com.isi.travailpratique.entity;

public class Activity extends Entity {

    private String wording;
    private String image;
    private Float price;

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

    public Activity(int id, String wording, String image, Float price) {
        super(id);
        this.wording = wording;
        this.image = image;
        this.price = price;
    }

   
}
