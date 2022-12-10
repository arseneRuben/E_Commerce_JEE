/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.isi.travailpratique.entity;

import java.util.Date;

/**
 *
 * @author isi
 */
public class Comment extends Entity{

    private String content;
    int commentLine_id;
    private Date created_at;
    private User author_id;

    public Comment(String content, int commentLine_id, int id) {
        super(id);
        this.content = content;
        this.commentLine_id = commentLine_id;
     //   this.created_at = created_at;
    }
    

    public Comment(String content, int commentLine_id, Date created_at, User author_id, int id) {
        super(id);
        this.content = content;
        this.commentLine_id = commentLine_id;
        this.created_at = created_at;
        this.author_id = author_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCommentLine_id() {
        return commentLine_id;
    }

    public void setCommentLine_id(int commentLine_id) {
        this.commentLine_id = commentLine_id;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public User getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(User author_id) {
        this.author_id = author_id;
    }

  
   

   

   
}
