package com.blacklightning;

import java.sql.Connection;

public class TestDBConnection {

    public static void main(String[] args) {

        try {
            Connection conn = DBConnection.getConnection();

            System.out.println("DATABASE CONNECTED!");

            conn.close();

        } catch (Exception e) {
            System.out.println("DATABASE CONNECTION FAILED!");
            e.printStackTrace();
        }
    }
}