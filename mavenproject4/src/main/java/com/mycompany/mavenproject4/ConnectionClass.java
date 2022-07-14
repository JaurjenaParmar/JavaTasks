/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author O7 Services
 */
public class ConnectionClass {

    private static ConnectionClass single_instance = null;
    Connection connection;

    private ConnectionClass() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testingdata","root", "");
            if (connection != null) {
                System.out.println("connected");
             
                String query = "CREATE TABLE IF NOT EXISTS testing (ID INTEGER NOT NULL AUTO_INCREMENT, "
                        + "Image VARCHAR(255), "
                        + "PRIMARY KEY(ID))";

                PreparedStatement preparedStatement1 = connection.prepareStatement(query);

                preparedStatement1.execute();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ConnectionClass getInstance() {
        if (single_instance == null) {
            single_instance = new ConnectionClass();

        }
        return single_instance;
    }

}
