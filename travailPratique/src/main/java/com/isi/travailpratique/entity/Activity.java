package com.isi.travailpratique.entity;

import java.util.ArrayList;
import java.util.List;

public class Activity extends Entity {

    private String wording;
    private int site_id;
    private Float price;
    private List<Image> images;

    
    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    
    public String getWording() {
        return wording;
    }

    public void setWording(String wording) {
        this.wording = wording;
    }

    public int getSite_id() {
        return site_id;
    }

    public void setSite_id(int site_id) {
        this.site_id = site_id;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Activity(int id, String wording,int site, Float price) {
        super(id);
        this.wording = wording;
        this.site_id = site;
        this.price = price;
        this.images = new ArrayList<>();
    }

    
    public Activity(int id, String wording, Site  site, Float price) {
        super(id);
        this.wording = wording;
        this.site_id = site.getId();
        this.price = price;
    }
   
}
