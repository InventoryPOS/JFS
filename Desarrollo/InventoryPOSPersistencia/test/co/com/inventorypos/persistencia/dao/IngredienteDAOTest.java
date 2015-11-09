/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.inventorypos.persistencia.dao;

import co.com.inventorypos.comun.vo.IngredienteVO;
import co.com.inventorypos.comun.vo.InsumoVO;
import co.com.inventorypos.persistencia.AdminConnection;
import co.com.inventorypos.persistencia.PersistenciaExcepcion;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author FernandoMora
 */
public class IngredienteDAOTest {
    private Connection conexion;
    IngredienteDAO dao;
    
    public IngredienteDAOTest() {
    }
    
    @Before
    public void setUp() {
        AdminConnection c = new AdminConnection();
        try {
            c.createConnection();
        } catch (PersistenciaExcepcion ex) {
            fail("falla al crear conexion");
        }
        conexion = c.getConnection();
        dao = new IngredienteDAO(conexion);
    }
    
    @After
    public void tearDown() {
        try {
            conexion.close();
        } catch (SQLException ex) {
        }
    }

    /**
     * Test of crearIngrediente method, of class IngredienteDAO.
     */
    @Test
    public void testCrearIngrediente(){
        System.out.println("crearIngrediente");
        IngredienteVO ingrediente = new IngredienteVO();
        ingrediente.setCantidad(10);
        ingrediente.setIdReceta(1);
        InsumoVO insumo = new InsumoVO();
        insumo.setIdInsumo(1);
        ingrediente.setInsumo(insumo);
        try {
            dao.crearIngrediente(ingrediente);
        } catch (PersistenciaExcepcion ex) {
            fail("falla en crearIngrediente");
        } catch (Exception e){
            fail("falla en crearIngrediente. Exception");
        }
        // TODO review the generated test code and remove the default call to fail.
        assertNotSame(0, ingrediente.getIdIngrediente());
    }
    
}
