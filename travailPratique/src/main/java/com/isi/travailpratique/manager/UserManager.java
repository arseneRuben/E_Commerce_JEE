/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.isi.travailpratique.manager;

import com.isi.travailpratique.entity.User;
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
public class UserManager extends Manager {

    private static ArrayList<User> users = new ArrayList<User>();

    public static ArrayList<User> findAll() {
        String query = "SELECT * FORM user;";
        try {
            connexion = DriverManager.getConnection(urlServeur, username, password);
            PreparedStatement ps = connexion.prepareStatement(query);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                int id = result.getInt("id");
                String email = result.getString("email");
                String pwd = result.getString("password");
                int gender = result.getInt("gender");
                users.add(new User(id, email, pwd, gender));
            }
            if (connexion != null) {
                connexion.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }
    
    public static User findById(int id) {
        User output = null;
        String query = "SELECT * FROM user WHERE id = ?;";
        try {
            connexion = DriverManager.getConnection(urlServeur, username, password);
            PreparedStatement ps = connexion.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet result = ps.executeQuery();
            if (result.next() == true) {
                String email = result.getString("email");
                String pwd = result.getString("password");
                int gender = result.getInt("gender");
                output = new User(id, email, pwd, gender);

            }
            if (connexion != null) {
                connexion.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return output;
    }
    
    
     public static User findById(String email) {
        User output = null;
        String query = "SELECT * FROM user WHERE email = ?;";
        try {
            connexion = DriverManager.getConnection(urlServeur, username, password);
            PreparedStatement ps = connexion.prepareStatement(query);
            ps.setString(1, email);
            ResultSet result = ps.executeQuery();
            if (result.next() == true) {
                int id = result.getInt("id");
                String pwd = result.getString("password");
                int gender = result.getInt("gender");
                output = new User(id, email, pwd, gender);

            }
            if (connexion != null) {
                connexion.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return output;
    }

}
