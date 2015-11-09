/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.inventorypos.persistencia.dao;

import co.com.inventorypos.comun.vo.IngredienteVO;
import co.com.inventorypos.persistencia.PersistenciaExcepcion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author FernandoMora
 */
public class IngredienteDAO {
    private Connection connection;

    public IngredienteDAO(Connection connection) {
        this.connection = connection;
    }
    public void crearIngrediente(IngredienteVO ingrediente) throws PersistenciaExcepcion{
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = "INSERT INTO IPOS_INGREDIENTE "
                    + "(INGREDIENTE_ID,CANTIDAD_INGREDIENTE,INSUMO_ID,RECETA_ID) "
                    + " VALUES "
                    + "(?,?,?,?)";
        try {
            statement = connection.prepareCall("SELECT SEQ_IPOS_INGREDIENTE.NEXTVAL FROM DUAL");
            resultSet = statement.executeQuery();
            int nextID = 0;
            if( resultSet.next() ){
                nextID = resultSet.getInt(1);
            }
            ingrediente.setIdIngrediente(nextID);
            statement = connection.prepareStatement(sql);
            int nParameter = 1;
            statement.setInt(nParameter++, ingrediente.getIdIngrediente());
            statement.setDouble(nParameter++,ingrediente.getCantidad() );
            statement.setInt(nParameter++, ingrediente.getInsumo().getIdInsumo());
            statement.setInt(nParameter++, ingrediente.getIdReceta());
            
            boolean result = statement.execute();
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
