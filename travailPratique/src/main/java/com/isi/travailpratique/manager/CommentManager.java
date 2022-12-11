package com.isi.travailpratique.manager;

import com.isi.travailpratique.entity.Comment;

import com.isi.travailpratique.entity.Activity;
import static com.isi.travailpratique.manager.Manager.connexion;
import static com.isi.travailpratique.manager.Manager.password;
import static com.isi.travailpratique.manager.Manager.urlServeur;
import static com.isi.travailpratique.manager.Manager.username;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CommentManager extends Manager {

    public static ArrayList<Comment> findById(int commandLine_id) {
        ArrayList<Comment> comments = new ArrayList<>();
        String query = "select * from comment where commandLine_id = ?;";

        try {
            connexion = DriverManager.getConnection(urlServeur, username, password);
            PreparedStatement ps = connexion.prepareStatement(query);
            ps.setInt(1, commandLine_id);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                int id = result.getInt("id");
                String content = result.getString("content");
                Date createdAt = result.getDate("createdAt");
                int commandLineId = result.getInt("commandLine_id");
                comments.add(new Comment(content, commandLineId, createdAt, id));
            }
            if (connexion != null) {
                connexion.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ActivityManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return comments;
    }

    public static void main(String args[]) {
        ArrayList<Comment> comments = CommentManager.findById(1);
        for (Comment comment : comments) {
            System.out.println(comment.getId());
            System.out.println(comment.getContent());
            System.out.println(comment.getCreated_at());
            System.out.println(comment.getCommentLine_id());

        }

    }

}
