/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.isi.travailpratique.entity;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author isi
 */
public class Command extends Entity {
    private int client_id;
    private Date createdAt;
    private ArrayList<CommandLine> commnadLines;

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public ArrayList<CommandLine> getCommnadLines() {
        return commnadLines;
    }

    public void setCommnadLines(ArrayList<CommandLine> commnadLines) {
        this.commnadLines = commnadLines;
    }

    public Command(int id,int client_id, Date createdAt, ArrayList<CommandLine> commnadLines) {
        super(id);
        this.client_id = client_id;
        this.createdAt = createdAt;
        this.commnadLines = commnadLines;
    }
    
    
    
}
