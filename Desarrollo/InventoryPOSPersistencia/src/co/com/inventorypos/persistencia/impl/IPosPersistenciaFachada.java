/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.inventorypos.persistencia.impl;

import co.com.inventorypos.comun.enums.EnumFuncionalidades;
import co.com.inventorypos.comun.enums.EnumPerfil;
import co.com.inventorypos.persistencia.AdminConnection;
import co.com.inventorypos.persistencia.IIPosPersistenciaFachada;
import co.com.inventorypos.persistencia.PersistenciaExcepcion;
import co.com.inventorypos.persistencia.dao.CredencialesDAO;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author FernandoMora
 */
public class IPosPersistenciaFachada implements IIPosPersistenciaFachada{
    private static IIPosPersistenciaFachada instancia;
    private AdminConnection adminConnection;

    private IPosPersistenciaFachada() {
        adminConnection = new AdminConnection();
    }
    
    public static IIPosPersistenciaFachada getInstancia(){
        if( instancia == null ){
            instancia = new IPosPersistenciaFachada();
        }
        return instancia;
    }

    @Override
    public EnumPerfil validarUsuario(String usuario, String password) throws PersistenciaExcepcion {
        adminConnection.createConnection();
        Connection connection = adminConnection.getConnection();
        EnumPerfil perfil = new CredencialesDAO(connection).verificarCredenciales(usuario, password);
        adminConnection.closeConnection();
        return perfil;
    }

    


    @Override
    public List<EnumFuncionalidades> getFuncionalidades(EnumPerfil perfil) throws PersistenciaExcepcion {
        adminConnection.createConnection();
        Connection connection = adminConnection.getConnection();
        List<EnumFuncionalidades> funcionalidades = new CredencialesDAO(connection).getFuncionalidades(perfil);
        adminConnection.closeConnection();
        return funcionalidades;
    }
}
