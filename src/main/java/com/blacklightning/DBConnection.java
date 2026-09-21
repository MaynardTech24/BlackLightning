package com.blacklightning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static final String URL =
	        "jdbc:mariadb://localhost:3306/black_lightning_db";

    private static final String USER = "root";

    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {

        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}