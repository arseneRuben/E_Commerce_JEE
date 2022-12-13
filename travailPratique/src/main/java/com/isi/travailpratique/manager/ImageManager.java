package com.isi.travailpratique.manager;

import com.isi.travailpratique.entity.Image;
import com.isi.travailpratique.entity.Site;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ImageManager extends Manager {

    //pictures of a site
    public static ArrayList<Image> findBySite(int site_id) {
        ArrayList<Image> images = new ArrayList<>();
        String query = "SELECT * FROM  images WHERE item_id=? AND type=1;";

        try {
            Connection connection = Manager.getConnection();
            PreparedStatement ps = Manager.getPreparedStatement(connection, query);
            ps.setInt(1, site_id);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                int id = result.getInt("id");
                String path = result.getString("path");
                images.add(new Image(id, path, site_id));
            }
            Manager.closeConnection(connection);

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return images;
    }

    public static ArrayList<Image> findByActivity(int activity_id) {
        ArrayList<Image> images = new ArrayList<>();
        String query = "SELECT * FROM  images WHERE item_id=? AND type=2;";

        try {
            Connection connection = Manager.getConnection();
            PreparedStatement ps = Manager.getPreparedStatement(connection, query);
            ps.setInt(1, activity_id);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                int id = result.getInt("id");
                String path = result.getString("path");
                images.add(new Image(id, path,  activity_id));
            }
            Manager.closeConnection(connection);

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return images;

    }

    public static void main(String... args) {
        System.out.print(ImageManager.findByActivity(1));
                System.out.print(ImageManager.findBySite(3));

    }

}
