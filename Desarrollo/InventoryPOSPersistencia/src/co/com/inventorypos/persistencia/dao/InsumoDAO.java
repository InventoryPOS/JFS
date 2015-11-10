/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.inventorypos.persistencia.dao;

import co.com.inventorypos.comun.vo.InsumoVO;
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
public class InsumoDAO {
    private Connection connection;

    public InsumoDAO(Connection connection) {
        this.connection = connection;
    }

    public void crearInsumo(InsumoVO insumo) throws PersistenciaExcepcion {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = "INSERT INTO IPOS_INSUMO "
                + "(INSUMO_ID,NOMBRE,CANTIDAD,DESCRIPCION,NIVEL_MINIMO,NIVEL_OPTIMO,UNIDAD_MEDIDA_ID,CODIGO_INSUMO)"
                + " VALUES "
                + "(?,?,?,?,?,?,?,?)";
        try {
            statement = connection.prepareCall("SELECT SEQ_IPOS_INSUMO.NEXTVAL FROM DUAL");
            resultSet = statement.executeQuery();
            int idInsumo = 0;
            if( resultSet.next() ){
                idInsumo = resultSet.getInt(1);
            }
            insumo.setIdInsumo(idInsumo);
            statement = connection.prepareStatement(sql);
            int nParameter = 1;
            statement.setInt(nParameter++, insumo.getIdInsumo());
            statement.setString(nParameter++, insumo.getNombre());
            statement.setDouble(nParameter++, insumo.getCantidad());
            statement.setString(nParameter++, insumo.getDescripcion());
            statement.setDouble(nParameter++, insumo.getNivelMinimo());
            statement.setDouble(nParameter++, insumo.getNivelOptimo());
            statement.setInt(nParameter++, insumo.getUnidad().getUnidadMedidaId());
            statement.setString(nParameter++, insumo.getCodInsumo());
            
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

    public void actualizarInsumo(InsumoVO insumo) throws PersistenciaExcepcion {
        PreparedStatement statement = null;
        String sql = "UPDATE IPOS_INSUMO "
                + " SET "
                + " CANTIDAD = ? , NIVEL_MINIMO = ?, NIVEL_OPTIMO = ? "
                + " WHERE INSUMO_ID = ?";
        try {
            statement = connection.prepareStatement(sql);
            int nParameter = 1;
            statement.setDouble(nParameter++, insumo.getCantidad());
            statement.setDouble(nParameter++, insumo.getNivelMinimo());
            statement.setDouble(nParameter++, insumo.getNivelOptimo());
            statement.setInt(nParameter++, insumo.getIdInsumo());
            
            boolean result = statement.execute();
        } catch(Exception e){
            e.printStackTrace();
            throw new PersistenciaExcepcion();
        }finally{
            try {
                statement.close();
            } catch (SQLException ex) {
            }
        }
    }

    public List<InsumoVO> getInsumos() throws PersistenciaExcepcion {
        return getInsumos(null, null);
    }
    public List<InsumoVO> getInsumos(String codigo, String nombre) throws PersistenciaExcepcion {
        List<InsumoVO> lista = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM IPOS_INSUMO_VIEW WHERE 1=1 ";
        if( (Object)codigo != null ){
            sql += " AND CODIGO_INSUMO = ?";
        }
        if( (Object)nombre != null ){
            sql += " AND UPPER(NOMBRE) LIKE ?";
        }
        try {
            statement = connection.prepareStatement(sql);
            int nParameter = 1;
            if( (Object)codigo != null ){
                statement.setString(nParameter++, codigo);
            }
            if( (Object)nombre != null ){
                statement.setString(nParameter++, "%"+nombre.toUpperCase()+"%");
            }
            
            resultSet = statement.executeQuery();
            InsumoVO vo = null;
            while( resultSet.next() ){
                vo = new InsumoVO();
                vo.setCantidad(resultSet.getDouble("CANTIDAD"));
                vo.setCodInsumo(resultSet.getString("CODIGO_INSUMO"));
                vo.setDescripcion(resultSet.getString("DESCRIPCION"));
                vo.setIdInsumo(resultSet.getInt("INSUMO_ID"));
                vo.setNivelMinimo(resultSet.getDouble("NIVEL_MINIMO"));
                vo.setNivelOptimo(resultSet.getDouble("NIVEL_OPTIMO"));
                vo.setNombre(resultSet.getString("NOMBRE"));
                vo.getUnidad().setCodUnidadMedida("COD_UNIDAD_MEDIDA");
                vo.getUnidad().setNombre("NOMBRE_UM");
                vo.getUnidad().setPermiteDecimales((resultSet.getInt("PERMITE_DECIMALES")== 1));
                vo.getUnidad().setSimbolo(resultSet.getString("SIMBOLO"));
                vo.getUnidad().setUnidadMedidaId(resultSet.getInt("UNIDAD_MEDIDA_ID"));
                lista.add(vo);
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
