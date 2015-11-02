/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.inventorypos.persistencia.impl;

import co.com.inventorypos.comun.enums.EnumFuncionalidades;
import co.com.inventorypos.comun.enums.EnumPerfil;
import co.com.inventorypos.persistencia.IIPosPersistenciaFachada;
import co.com.inventorypos.persistencia.PersistenciaExcepcion;
import co.com.inventorypos.persistencia.dao.CredencialesDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author FernandoMora
 */
public class IPosPersistenciaFachada implements IIPosPersistenciaFachada{
    private static IIPosPersistenciaFachada instancia;
    private Connection connection;

    private IPosPersistenciaFachada() {
    }
    
    public static IIPosPersistenciaFachada getInstancia(){
        if( instancia == null ){
            instancia = new IPosPersistenciaFachada();
        }
        return instancia;
    }

    @Override
    public EnumPerfil validarUsuario(String usuario, String password) throws PersistenciaExcepcion {
        createConnection();
        EnumPerfil perfil = new CredencialesDAO(connection).verificarCredenciales(usuario, password);
        closeConnection();
        return perfil;
    }

    private void createConnection() throws PersistenciaExcepcion {
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

    private void closeConnection() {
        try {
            connection.close();
        } catch (SQLException ex) {
        }
    }

    @Override
    public List<EnumFuncionalidades> getFuncionalidades(EnumPerfil perfil) throws PersistenciaExcepcion {
        createConnection();
        List<EnumFuncionalidades> funcionalidades = new CredencialesDAO(connection).getFuncionalidades(perfil);
        closeConnection();
        return funcionalidades;
    }
}
