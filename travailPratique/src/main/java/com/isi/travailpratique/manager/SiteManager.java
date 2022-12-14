/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.isi.travailpratique.manager;

import com.isi.travailpratique.entity.Site;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author isi
 */
public class SiteManager extends Manager {

    public static ArrayList<Site> findAll() {
        ArrayList<Site> sites = new ArrayList<>();
        String query = "SELECT * FROM  sites;";

        try {
            Connection connection = Manager.getConnection();
            PreparedStatement ps = Manager.getPreparedStatement(connection, query);

            ResultSet result = ps.executeQuery();
            while (result.next()) {
                int id = result.getInt("id");

                String name = result.getString("name");
                String address = result.getString("address");
                String description = result.getString("description");
                Site site = new Site(id, name, address, description);
                site.setImages(ImageManager.findBySite(id));
                sites.add(site);
            }
            Manager.closeConnection(connection);

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sites;
    }

    public static Site findById(int id) {
        Site site = null;
        String query = "select * from sites where id = ?;";

        try {
            Connection connection = Manager.getConnection();
            PreparedStatement ps = Manager.getPreparedStatement(connection, query);

            ps.setInt(1, id);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                String wording = result.getString("name");
                String address = result.getString("address");
                String description = result.getString("description");

                site = new Site(id, wording, address, description);
                site.setImages(ImageManager.findByActivity(id));

            }
            if (connexion != null) {
                connexion.close();
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ActivityManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return site;
    }

}
