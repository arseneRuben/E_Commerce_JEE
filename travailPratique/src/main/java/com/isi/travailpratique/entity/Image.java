package com.isi.travailpratique.entity;

public class Image extends Entity {
private int site_id;
private String path;
private int activity_id;


    public Image(int id,int site_id, String path) {
        super(id);
        this.site_id = site_id;
        this.path = path;
    }
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getActivity_id() {
        return activity_id;
    }

    public void setActivity_id(int activity_id) {
        this.activity_id = activity_id;
    }
}
