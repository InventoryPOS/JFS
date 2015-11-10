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
import java.util.ArrayList;
import java.util.List;

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

    public List<RecetaVO> getRecetas(String codigo, String nombre) throws PersistenciaExcepcion {
        List<RecetaVO> lista = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM IPOS_RECETA_VIEW WHERE 1=1 ";
        /*
        if( (Object)codigo != null ){
            sql += " AND CODIGO_INSUMO = ?";
        }*/
        if( (Object)nombre != null && !nombre.isEmpty() ){
            sql += " AND UPPER(NOMBRE_RECETA) LIKE ?";
        }
        sql += " ORDER BY RECETA_ID DESC";
        try {
            statement = connection.prepareStatement(sql);
            int nParameter = 1;
           /* if( (Object)codigo != null ){
                statement.setString(nParameter++, codigo);
            }*/
            if( (Object)nombre != null && !nombre.isEmpty() ){
                statement.setString(nParameter++, "%"+nombre.toUpperCase()+"%");
            }
            
            resultSet = statement.executeQuery();
            RecetaVO vo = null;
            int idActual = 0;
            IngredienteVO ingrediente;
            while( resultSet.next() ){
                idActual = resultSet.getInt("RECETA_ID");
                if( vo == null || vo.getIdReceta() != idActual ){
                    vo = new RecetaVO();
                    vo.setIdReceta(idActual);
                    vo.setNombre(resultSet.getString("NOMBRE_RECETA"));
                    vo.setDescripcion(resultSet.getString("DESCRIPCION_RECETA"));
                    lista.add(vo);
                }
                ingrediente = new IngredienteVO();
                ingrediente.setCantidad(resultSet.getDouble("CANTIDAD_INGREDIENTE"));
                ingrediente.setIdIngrediente(resultSet.getInt("INGREDIENTE_ID"));
                ingrediente.setIdReceta(idActual);
                ingrediente.getInsumo().setIdInsumo(resultSet.getInt("INSUMO_ID"));
                ingrediente.getInsumo().setNombre(resultSet.getString("NOMBRE_INGREDIENTE"));
                ingrediente.getInsumo().getUnidad().setUnidadMedidaId(resultSet.getInt("UNIDAD_MEDIDA_ID"));
                ingrediente.getInsumo().getUnidad().setNombre("NOMBRE_UM");
                vo.getIngredientes().add(ingrediente);
            }
            return lista;
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
