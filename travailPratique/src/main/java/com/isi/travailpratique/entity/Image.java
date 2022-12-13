package com.isi.travailpratique.entity;

public class Image extends Entity {
private int item_id;
private String path;
private int type;  // 1-->Site   2-->Activity


    public Image(int id,String path, int item_id) {
        super(id);
        this.item_id = item_id;
        this.path = path;
    }
    
   
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

  
}
