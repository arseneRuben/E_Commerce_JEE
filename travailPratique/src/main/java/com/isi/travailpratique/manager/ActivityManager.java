package com.isi.travailpratique.manager;

import com.isi.travailpratique.entity.Activity;
import com.isi.travailpratique.entity.Site;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ActivityManager extends Manager {
    
        public static ArrayList<Activity> findAll() {
        ArrayList<Activity> activities = new ArrayList<>();
;        String query = "SELECT * FROM  activities;";

        try {
            Connection connection = Manager.getConnection();
            PreparedStatement ps = Manager.getPreparedStatement(connection, query);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                 int id = result.getInt("id");
                String wording = result.getString("wording");
                int site_id = result.getInt("site_id");
                Float price = result.getFloat("price");
                activities.add(new Activity(id, wording, site_id, price));
            }
            Manager.closeConnection(connection);

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return activities;
    }
    
        
        
    public static Activity findById(int id) {
        Activity  activiity = null;
        String query = "select * from activities where id = ?;";

        try {
            connexion = DriverManager.getConnection(urlServeur, username, password);
            PreparedStatement ps = connexion.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                String wording = result.getString("wording");
                int site_id = result.getInt("site_id");
                float price = result.getFloat("price");
               activiity = (new Activity(id, wording, site_id,  price));
            }
            if (connexion != null) {
                connexion.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ActivityManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return activiity;
    }


    public static ArrayList<Activity> findBySiteId(int site_id) {
        ArrayList<Activity> activities = new ArrayList<>();
        String query = "select * from activities where site_id = ?;";

        try {
            connexion = DriverManager.getConnection(urlServeur, username, password);
            PreparedStatement ps = connexion.prepareStatement(query);
            ps.setInt(1, site_id);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                int id = result.getInt("id");
                String wording = result.getString("wording");
                // String image = result.getString("image");
                float price = result.getFloat("price");
                activities.add(new Activity(id, wording, site_id,  price));
            }
            if (connexion != null) {
                connexion.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ActivityManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return activities;
    }

    public static ArrayList<Activity> findByName(String name) {
        ArrayList<Activity> activities = new ArrayList<>();
        String query = "select * from activities  where wording  like  ?;";
        try {
            connexion = DriverManager.getConnection(urlServeur, username, password);
            PreparedStatement ps = connexion.prepareStatement(query);
            ps.setString(1, name);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                int id = result.getInt("id");
                String wording = result.getString("wording");
                int  site_id = result.getInt("site_id");
                float price = result.getFloat("price");
                activities.add(new Activity(id, wording, site_id, price));
            }
            if (connexion != null) {
                connexion.close();

            }
        } catch (SQLException ex) {
            Logger.getLogger(ActivityManager.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return activities;
    }

    public static void main(String args[]) {
       /* ArrayList<Activity> activityList = ActivityManager.findBySiteId(1);
        for (Activity activity : activityList) {
            System.out.printf("Activity id:%d,  wording:%s,   price:%f\n", activity.getId(), activity.getWording(), activity.getPrice());
        }
        System.out.println("********************************************************************");
        ArrayList<Activity> activities = ActivityManager.findByName("Visite");
        for (Activity activity : activities) {
            System.out.printf("Activity id:%d,  wording:%s,   price:%f\n", activity.getId(), activity.getWording(), activity.getPrice());
        }*/
       Activity activity = ActivityManager.findById(2);
         System.out.printf("Activity id:%d,  wording:%s,   price:%f\n", activity.getId(), activity.getWording(), activity.getPrice());
       
    }
}
