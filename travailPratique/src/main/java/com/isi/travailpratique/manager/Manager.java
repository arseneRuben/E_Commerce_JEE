package com.isi.travailpratique.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public abstract class Manager {

    protected static String dbName = "visites";
    protected static String urlServeur = "jdbc:mariadb://localhost:3306/" + dbName;
    protected static String username = "root";
    protected static String password = "abc123...";
    protected static Connection connexion;
    protected PreparedStatement statement;
    protected ResultSet result;
    protected String query;

}
