/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.inventorypos.persistencia.dao;

import co.com.inventorypos.comun.vo.InsumoConsumidoVO;
import co.com.inventorypos.persistencia.PersistenciaExcepcion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author FernandoMora
 */
public class InsumoConsumidoDAO {
    public Connection connection;

    public InsumoConsumidoDAO(Connection connection) {
        this.connection = connection;
    }
    public List<InsumoConsumidoVO> getInsumosConsumidos(Date fechaInicial, Date fechaFinal) throws PersistenciaExcepcion {
        List<InsumoConsumidoVO> lista = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM IPOS_INSUMO_CONSUMO_VIEW WHERE 1=1 ";
        if( (Object)fechaInicial != null ){
            sql += " AND FECHA_CONSUMO >= ?";
        }
        if( (Object)fechaFinal != null ){
            sql += " AND FECHA_CONSUMO <= ?";
        }
        try {
            statement = connection.prepareStatement(sql);
            int nParameter = 1;
            if( (Object)fechaInicial != null ){
                statement.setDate(nParameter++, new java.sql.Date(fechaInicial.getTime()));
            }
            if( (Object)fechaFinal != null ){
                statement.setDate(nParameter++, new java.sql.Date(fechaFinal.getTime()));
            }
            
            resultSet = statement.executeQuery();
            InsumoConsumidoVO vo = null;
            while( resultSet.next() ){
                vo = new InsumoConsumidoVO();
                vo.setCantidad(resultSet.getDouble("CANTIDAD_CONSUMIDA"));
                vo.setFechaConsumo(resultSet.getDate("FECHA_CONSUMO"));
                vo.setIdInsumoConsumo(resultSet.getInt("INSUMO_CONSUMO_ID"));
                vo.getInsumo().setNombre(resultSet.getString("INSUMO_NOM"));
                vo.getInsumo().setIdInsumo(resultSet.getInt("INSUMO_ID"));
                vo.getInsumo().getUnidad().setUnidadMedidaId(resultSet.getInt("UNIDAD_MEDIDA_ID"));
                vo.getInsumo().getUnidad().setSimbolo(resultSet.getString("SIMBOLO"));
                vo.getInsumo().getUnidad().setNombre(resultSet.getString("UNIDAD_MEDIDA"));
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
