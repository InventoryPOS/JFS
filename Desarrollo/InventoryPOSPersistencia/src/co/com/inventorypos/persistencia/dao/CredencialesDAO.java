package co.com.inventorypos.persistencia.dao;

import co.com.inventorypos.comun.enums.EnumFuncionalidades;
import co.com.inventorypos.comun.enums.EnumPerfil;
import co.com.inventorypos.persistencia.PersistenciaExcepcion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author FernandoMora
 */
public class CredencialesDAO {
    private final Connection connection;

    public CredencialesDAO(Connection connection) {
        this.connection = connection;
    }
    
    public List<EnumFuncionalidades> getFuncionalidades(EnumPerfil perfil) throws PersistenciaExcepcion{
        List<EnumFuncionalidades> listaFuncionalidades = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = "SELECT F.NOMBRE FROM IPOS_PERF_FUNC PF, IPOS_PERFIL P, IPOS_FUNCION F \n" +
                    "WHERE \n" +
                    "PF.FUNCION_ID = F.FUNCION_ID \n" +
                    "AND PF.PERFIL_ID = P.PERFIL_ID \n" +
                    "AND P.NOMBRE = ?";
        
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, perfil.name());
            resultSet = statement.executeQuery();
            while( resultSet.next() ){
                String nombreFuncionalidad = resultSet.getString("NOMBRE");
                EnumFuncionalidades funcion = EnumFuncionalidades.valueOf(nombreFuncionalidad);
                listaFuncionalidades.add(funcion);
            }
            return listaFuncionalidades;
        } catch(Exception e){
            e.printStackTrace();
            throw new PersistenciaExcepcion();
        }finally{
            try {
                statement.close();
            } catch (SQLException ex) {
            }
            try {
                resultSet.close();
            } catch (SQLException ex) {
            }
        }
    }
    public EnumPerfil verificarCredenciales(String usuario, String password) throws PersistenciaExcepcion{
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = "SELECT U.*, P.NOMBRE PERFIL FROM IPOS_USUARIO U, IPOS_PERFIL P WHERE U.PERFIL_ID = P.PERFIL_ID AND U.NOMBRE = ? AND U.PASS_USU = ?";
        try {
            EnumPerfil perfil = null;
            statement = connection.prepareStatement(sql);
            statement.setString(1, usuario);
            statement.setString(2, password);
            resultSet = statement.executeQuery();
            if( resultSet.next() ){
                String perfilDB = resultSet.getString("PERFIL");
                perfil = EnumPerfil.valueOf(perfilDB);
            }
            return perfil;
        } catch(Exception e){
            e.printStackTrace();
            throw new PersistenciaExcepcion();
        }finally{
            try {
                statement.close();
            } catch (SQLException ex) {
            }
            try {
                resultSet.close();
            } catch (SQLException ex) {
            }
        }
    }
}
