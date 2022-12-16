/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.isi.travailpratique.entity;

/**
 *
 * @author isi
 */
public class User extends Entity {

    private String email;
    private String password;
    private int gender;
    private int statu;
    
    


    public User(int id, String email, String password, int gender) {
        super(id);
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.statu = 0;

    }
    
        public User( String email, String password, int gender) {
        super(0);
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.statu = 0;

    }
    
    
    
        public int getStatu() {
        return statu;
    }

    public void setStatu(int statu) {
        this.statu = statu;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }
//    public String toString(){
//        
//        return this.id + " " + this.email; 
//    }

}
