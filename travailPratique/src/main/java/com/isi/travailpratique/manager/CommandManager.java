package com.isi.travailpratique.manager;

import com.isi.travailpratique.entity.Activity;
import com.isi.travailpratique.entity.Command;
import com.isi.travailpratique.entity.CommandLine;
import com.isi.travailpratique.entity.User;
import static com.isi.travailpratique.manager.Manager.connexion;
import static com.isi.travailpratique.manager.Manager.password;
import static com.isi.travailpratique.manager.Manager.urlServeur;
import static com.isi.travailpratique.manager.Manager.username;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CommandManager {

    public static ArrayList<Command> findBy(User user_id) {
        ArrayList<Command> commands = new ArrayList<>();

        return commands;
    }

    public static int addCommandLine(CommandLine commandLine) {
        int result = -1;
        String query = "INSERT  INTO  Command(activity_id, command_id,visitorsNumber )  VALUES  (?, ?, ?) ;";
        try {
            connexion = DriverManager.getConnection(urlServeur, username, password);
            PreparedStatement ps = connexion.prepareStatement(query);
            ps.setInt(1, commandLine.getActivity_id());
            ps.setInt(2, commandLine.getCommand_id());
            ps.setInt(3, commandLine.getVisitorsNumber());
            result = ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            while (rs.next()) {
                result = rs.getInt(1);
            }
            connexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(CommandManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public static int removeCommandLine(Activity activity) {
        int result = -1;
        String query = "DELETE FROM  command WHERE id=?;";
        try {
            connexion = DriverManager.getConnection(urlServeur, username, password);
            PreparedStatement ps = connexion.prepareStatement(query);
            ps.setInt(1, activity.getId());
            result = ps.executeUpdate();
            connexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(CommandManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public static int update(Command command){
        int result = -1;
        String query = "UPDATE  commands SET id=?,  client_id=?;";
        try {
            Connection connection = Manager.getConnection();
            PreparedStatement ps = Manager.getPreparedStatement(connection, query);
           
            ps.setInt(1, command.getId());
            ps.setInt(2, command.getClient_id());
           
            result = ps.executeUpdate();
            Manager.closeConnection(connection);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }

    public static int insert(Command command) {
        int result = -1;
        String query = "INSERT  INTO  commands(client_id)  VALUES  ( ?) ;";
        try {
            Connection connection = Manager.getConnection();
            PreparedStatement ps = Manager.getPreparedStatement(connection, query);

            ps.setInt(1, command.getClient_id());
            result = ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys(); // retourne les clÃ©s autogÃ©nÃ©rÃ©es par la base de donnÃ©es
            while (rs.next()) {
                result = rs.getInt(1);
            }
          
            
            for(CommandLine line : command.getCommnadLines()){
                line.setCommand_id(result);
                CommandLineManger.insert(line);
            }
            
            Manager.closeConnection(connection);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
 

}
