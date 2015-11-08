/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.inventorypos.persistencia.dao;

import co.com.inventorypos.comun.vo.UnidadMedidaVO;
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
public class UnidadMedidaDAO {
    private final Connection connection;

    public UnidadMedidaDAO(Connection connection) {
        this.connection = connection;
    }

    public List<UnidadMedidaVO> getUnidadesMedida()throws PersistenciaExcepcion{
        List<UnidadMedidaVO> lista = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM IPOS_UNIDAD_MEDIDA";
        
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            UnidadMedidaVO unidad = null;
            while( resultSet.next() ){
                unidad = new UnidadMedidaVO();
                unidad.setCodUnidadMedida(resultSet.getString("COD_UNIDAD_MEDIDA"));
                unidad.setNombre(resultSet.getString("NOMBRE"));
                unidad.setPermiteDecimales((resultSet.getInt("PERMITE_DECIMALES")== 1));
                unidad.setSimbolo(resultSet.getString("SIMBOLO"));
                unidad.setUnidadMedidaId(resultSet.getInt("UNIDAD_MEDIDA_ID"));
                
                lista.add(unidad);
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
    public UnidadMedidaVO getUnidadMedida(int idUnidadMedida)throws PersistenciaExcepcion{
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM IPOS_UNIDAD_MEDIDA WHERE UNIDAD_MEDIDA_ID = ?";
        
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, idUnidadMedida);
            resultSet = statement.executeQuery();
            UnidadMedidaVO unidad = null;
            if( resultSet.next() ){
                unidad = new UnidadMedidaVO();
                unidad.setCodUnidadMedida(resultSet.getString("COD_UNIDAD_MEDIDA"));
                unidad.setNombre(resultSet.getString("NOMBRE"));
                unidad.setPermiteDecimales((resultSet.getInt("PERMITE_DECIMALES")== 1));
                unidad.setSimbolo(resultSet.getString("SIMBOLO"));
                unidad.setUnidadMedidaId(resultSet.getInt("UNIDAD_MEDIDA_ID"));
                
            }
            return unidad;
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
