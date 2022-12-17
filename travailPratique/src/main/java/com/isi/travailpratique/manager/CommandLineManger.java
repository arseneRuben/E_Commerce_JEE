/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.isi.travailpratique.manager;

import java.util.List;
import com.isi.travailpratique.entity.CommandLine;

import java.sql.Connection;
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
public class CommandLineManger extends Manager {

    public static List<CommandLine> findByCommand(int command_id) {
        List<CommandLine> items = new ArrayList<>();
        String query = "SELECT * FROM commandLines WHERE command_id = ?";
        try {
            Connection connection = Manager.getConnection();

            PreparedStatement ps = Manager.getPreparedStatement(connection, query);
            ps.setInt(1, command_id);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                int id = result.getInt("id");
                int activity_id = result.getInt("activity_id");
                int visitorsNumber = result.getInt("visitorsNumber");
                CommandLine line = new CommandLine(id, command_id, activity_id, visitorsNumber);
                items.add(line);
            }
            Manager.closeConnection(connection);

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return items;
    }

    public static int insert(CommandLine line) {
        int result = -1;
        String query = "INSERT  INTO  commandLines( activity_id, command_id, visitorsNumber)  VALUES  ( ?, ?,?) ;";
        try {
            Connection connection = Manager.getConnection();
            PreparedStatement ps = Manager.getPreparedStatement(connection, query);
           
            ps.setInt(1, line.getActivity_id());
            ps.setInt(2, line.getCommand_id());
            ps.setInt(3, line.getVisitorsNumber());
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

}
