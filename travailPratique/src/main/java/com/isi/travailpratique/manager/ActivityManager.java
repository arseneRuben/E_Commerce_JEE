package com.isi.travailpratique.manager;

import com.isi.travailpratique.entity.Activity;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ActivityManager extends Manager {
    public static ArrayList<Activity> activities=new ArrayList<>();
    
    public static ArrayList<Activity> findBy(int site_id){
    
     String query = "select * from activity where id = ?;";
        try {
            connexion = DriverManager.getConnection(urlServeur, username, password);
            PreparedStatement ps = connexion.prepareStatement(query);
            ps.setInt(1, site_id);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                int id = result.getInt("id");
                String wording = result.getString("wording");
                String image = result.getString("image");
                float price = result.getFloat("price");
                activities.add(new Activity(id, wording,image,price));
            }
            if (connexion != null) {
                connexion.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ActivityManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return activities;
    } 
public static ArrayList<Activity> findBy(String name){
   String query = "select * from activity where name = ?;";
        try {
            connexion = DriverManager.getConnection(urlServeur, username, password);
            PreparedStatement ps = connexion.prepareStatement(query);
            ps.setString(1, name);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                int id = result.getInt("id");
                String wording = result.getString("wording");
                String image = result.getString("image");
                float price = result.getFloat("price");
                activities.add(new Activity(id, wording,image,price));
            }
            if (connexion != null) {
                connexion.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ActivityManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return activities;
}

}
