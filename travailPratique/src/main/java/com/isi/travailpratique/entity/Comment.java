/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.isi.travailpratique.entity;
/**
 *
 * @author isi
 */
public class Comment {

    int comment_id;
    private String comment;
    int commentLine_id;
//    private DateTime createdAT;
    private User author;

    public Comment() {
    }

    public int getId() {
        return comment_id;
    }

    public void setId(int id) {
        this.comment_id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

}
