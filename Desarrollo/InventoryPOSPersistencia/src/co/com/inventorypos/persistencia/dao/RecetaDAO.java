/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.inventorypos.persistencia.dao;

import co.com.inventorypos.comun.vo.IngredienteVO;
import co.com.inventorypos.comun.vo.RecetaVO;
import co.com.inventorypos.persistencia.PersistenciaExcepcion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author FernandoMora
 */
public class RecetaDAO {
    private Connection connection;
    private IngredienteDAO ingredienteDAO;

    public RecetaDAO(Connection connection,IngredienteDAO ingredienteDAO) {
        this.connection = connection;
        this.ingredienteDAO = ingredienteDAO;
    }
    public void crearReceta(RecetaVO receta) throws PersistenciaExcepcion{
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = "INSERT INTO IPOS_RECETA "
                + "(RECETA_ID,NOMBRE_RECETA,DESCRIPCION_RECETA)"
                + " VALUES "
                + "(?,?,?)";
        try {
            statement = connection.prepareCall("SELECT SEQ_IPOS_RECETA.NEXTVAL FROM DUAL");
            resultSet = statement.executeQuery();
            int nextID = 0;
            if( resultSet.next() ){
                nextID = resultSet.getInt(1);
            }
            receta.setIdReceta(nextID);
            statement = connection.prepareStatement(sql);
            int nParameter = 1;
            statement.setInt(nParameter++, receta.getIdReceta());
            statement.setString(nParameter++, receta.getNombre());
            statement.setString(nParameter++, receta.getDescripcion());
            
            boolean result = statement.execute();
            for (IngredienteVO ingrediente : receta.getIngredientes()) {
                ingrediente.setIdReceta(receta.getIdReceta());
                ingredienteDAO.crearIngrediente(ingrediente);
            }
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
