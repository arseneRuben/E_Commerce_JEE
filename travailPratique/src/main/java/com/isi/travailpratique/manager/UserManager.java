/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.isi.travailpratique.manager;

import java.sql.Connection;
import com.isi.travailpratique.entity.User;
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

    public static ArrayList<User> findAll() {
        ArrayList<User> users = new ArrayList<User>();
        String query = "SELECT * FORM user;";

        try {
            Connection connection = Manager.getConnection();
            PreparedStatement ps = Manager.getPreparedStatement(connection, query);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                int id = result.getInt("id");
                String email = result.getString("email");
                String pwd = result.getString("password");
                int gender = result.getInt("gender");
                users.add(new User(id, email, pwd, gender));
            }
            Manager.closeConnection(connection);

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }

    public static User findOneById(int id) {
        User output = null;
        String query = "SELECT * FROM users WHERE id = ?;";
        try {
            Connection connection = Manager.getConnection();
            PreparedStatement ps = Manager.getPreparedStatement(connection, query);
            ps.setInt(1, id);
            ResultSet result = ps.executeQuery();
            if (result.next() == true) {
                String email = result.getString("email");
                String pwd = result.getString("password");
                int gender = result.getInt("gender");
                output = new User(id, email, pwd, gender);
            }
            Manager.closeConnection(connection);

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return output;
    }

    public static User findOneByEmail(String email) {
        User output = null;
        String query = "SELECT * FROM users WHERE email = ?;";
        try {
            Connection connection = Manager.getConnection();
            PreparedStatement ps = Manager.getPreparedStatement(connection, query);
            ps.setString(1, email);
            ResultSet result = ps.executeQuery();
            if (result.next() == true) {
                int id = result.getInt("id");
                String pwd = result.getString("password");
                int gender = result.getInt("gender");
                output = new User(id, email, pwd, gender);
            }
            Manager.closeConnection(connection);

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return output;
    }

    public static User findOneBy(String email, String pwd) {
        User output = null;
        String query = "SELECT * FROM users WHERE email = ? AND password=?;";
        try {
            Connection connection = Manager.getConnection();
            PreparedStatement ps = Manager.getPreparedStatement(connection, query);
            ps.setString(1, email);
            ps.setString(2, pwd);
            ResultSet result = ps.executeQuery();
            if (result.next() == true) {
                int id = result.getInt("id");
                int gender = result.getInt("gender");
                output = new User(id, email, pwd, gender);
            }
            Manager.closeConnection(connection);

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return output;
    }

    public static int insert(User user) {
        int result = -1;
        String query = "INSERT  INTO  users(email, password, gender)  VALUES  ( ?, ?,?) ;";
        try {
            Connection connection = Manager.getConnection();
            PreparedStatement ps = Manager.getPreparedStatement(connection, query);
            ps.setInt(1, user.getId());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setInt(3, user.getGender());
            result = ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys(); // retourne les clÃ©s autogÃ©nÃ©rÃ©es par la base de donnÃ©es
            while (rs.next()) {
                result = rs.getInt(1);
            }
            Manager.closeConnection(connection);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public static int update(User user) {
        int result = -1;
        String query = "UPDATE  users SET email=?,  password=?,  gender=?,  statu=? WHERE id=?;";
        try {
            Connection connection = Manager.getConnection();
            PreparedStatement ps = Manager.getPreparedStatement(connection, query);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ps.setInt(3, user.getGender());
            ps.setInt(4, user.getStatu());
            ps.setInt(5,user.getId());
            result = ps.executeUpdate();
            Manager.closeConnection(connection);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }
    public static void main(String ...args){
       /* System.out.println(UserManager.findOneBy("ruben@gmail.com","passwordRuben"));
        User us = (UserManager.findOneBy("ruben@gmail.com","passwordRuben"));
        us.setEmail("user@gmail.com");
        int a = UserManager.update(us);
        System.out.print(a);*/
       User ramat = new User( "raghghghgmaet@gmail.com", "pasghghswordRamat", 0 );
       int id = UserManager.insert(ramat);
       ramat.setId(id);
          int a = UserManager.update(ramat);
       System.out.print(UserManager.findOneById(id));
}

}
