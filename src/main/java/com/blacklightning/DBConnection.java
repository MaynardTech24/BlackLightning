package com.blacklightning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static final String URL =
	        "jdbc:mariadb://" + System.getenv("MYSQLHOST") + ":"
	        + System.getenv("MYSQLPORT") + "/"
	        + System.getenv("MYSQLDATABASE");

	private static final String USER = System.getenv("MYSQLUSER");

	private static final String PASSWORD = System.getenv("MYSQLPASSWORD");

    public static Connection getConnection() throws SQLException {

        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}