package com.isi.travailpratique.entity;

public class Image {
private int site_id;
private String path;
private int activity_id;

    public Image() {
    }

    public Image(int site_id, String path, int activity_id) {
        this.site_id = site_id;
        this.path = path;
        this.activity_id = activity_id;
    }

    public int getSite_id() {
        return site_id;
    }

    public void setSite_id(int site_id) {
        this.site_id = site_id;
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
