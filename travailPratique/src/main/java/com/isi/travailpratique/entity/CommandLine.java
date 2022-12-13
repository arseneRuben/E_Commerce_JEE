/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.isi.travailpratique.entity;

/**
 *
 * @author isi
 */
public class CommandLine extends Entity{
    
    private int command_id;
    private int activity_id;
    private int visitorsNumber;

    public CommandLine(int id, int command_id, int activity_id, int visitorsNumber) {
        super(id);
        this.command_id = command_id;
        this.activity_id = activity_id;
        this.visitorsNumber = visitorsNumber;
    }

    public CommandLine(int command_id, int activity_id, int visitorsNumber) {
        super(0);
        this.command_id = command_id;
        this.activity_id = activity_id;
        this.visitorsNumber = visitorsNumber;
    }

   
    public int getCommand_id() {
        return command_id;
    }

    public void setCommand_id(int command_id) {
        this.command_id = command_id;
    }

    public int getActivity_id() {
        return activity_id;
    }

    public void setActivity_id(int activity_id) {
        this.activity_id = activity_id;
    }

    public int getVisitorsNumber() {
        return visitorsNumber;
    }

    public void setVisitorsNumber(int visitorsNumber) {
        this.visitorsNumber = visitorsNumber;
    }
    
    
    
    
}
