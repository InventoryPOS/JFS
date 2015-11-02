/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.inventorypos.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author FernandoMora
 */
public class AdminConnection {
    private Connection connection;
    
    public void createConnection() throws PersistenciaExcepcion {
        try {
            Class.forName ("oracle.jdbc.OracleDriver");// Muy necesario con ambiente web
        } catch (ClassNotFoundException e) {
            throw new PersistenciaExcepcion("Loading Oracle Driver FAIL");
        }
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "SYSTEM";
        String password = "azumi";
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new PersistenciaExcepcion("Falla al crear conexion DB");
        }
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException ex) {
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
