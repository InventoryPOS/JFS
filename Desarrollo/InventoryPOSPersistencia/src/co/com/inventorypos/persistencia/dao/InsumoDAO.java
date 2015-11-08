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
    public Connection connection;

    public InsumoDAO(Connection connection) {
        this.connection = connection;
    }

    public void crearInsumo(InsumoVO insumo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void actualizarInsumo(InsumoVO insumo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<InsumoVO> getInsumos() throws PersistenciaExcepcion {
        List<InsumoVO> lista = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM IPOS_INSUMO_VIEW";
        
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            InsumoVO vo = null;
            while( resultSet.next() ){
                vo = new InsumoVO();
                vo.setCantidad(resultSet.getDouble("CANTIDAD"));
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
