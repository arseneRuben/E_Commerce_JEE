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

    public static ArrayList<Comment> findById(int activity_id) {
        ArrayList<Comment> comments = new ArrayList<>();
        String query = "select * from comment where activity_id = ?;";

        try {
            connexion = DriverManager.getConnection(urlServeur, username, password);
            PreparedStatement ps = connexion.prepareStatement(query);
            ps.setInt(1, activity_id);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                int id = result.getInt("id");
                String content = result.getString("content");
                // String image = result.getString("image");
              //  Date createdAt = result.getDate("createdAt");
                int commandLine_id= result.getInt("commandLine_Id");
                comments,add(new Comment ( content,commandLine_id, id));
            }
            if (connexion != null) {
                connexion.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ActivityManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return comments;
    }

}
