/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.inventorypos.persistencia.dao;

import co.com.inventorypos.comun.vo.IngredienteVO;
import co.com.inventorypos.comun.vo.InsumoVO;
import co.com.inventorypos.comun.vo.RecetaVO;
import co.com.inventorypos.persistencia.AdminConnection;
import co.com.inventorypos.persistencia.PersistenciaExcepcion;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
public class RecetaDAOTest {
    private Connection connection;
    private RecetaDAO dao;
    
    public RecetaDAOTest() {
    }
    
    @Before
    public void setUp() {
        AdminConnection c = new AdminConnection();
        try {
            c.createConnection();
        } catch (PersistenciaExcepcion ex) {
            fail("Falla al crear conexion");
        }
        connection = c.getConnection();
        dao = new RecetaDAO(connection, new IngredienteDAO(connection));
    }
    
    @After
    public void tearDown() {
        try {
            connection.close();
        } catch (SQLException ex) {
        }
    }

    /**
     * Test of crearReceta method, of class RecetaDAO.
     */
    @Test
    public void testCrearReceta() {
        System.out.println("crearReceta");
        RecetaVO receta = new RecetaVO();
        receta.setDescripcion("prueba test");
        receta.setNombre("prueba test");
        IngredienteVO ingrediente;
        InsumoVO insumo = new InsumoVO();
        insumo.setIdInsumo(1);
        for (int i = 0; i < 3; i++) {
            ingrediente = new IngredienteVO();
            ingrediente.setCantidad(10);
            ingrediente.setInsumo(insumo);
            receta.getIngredientes().add(ingrediente);
        }
        try {
            dao.crearReceta(receta);
        } catch (PersistenciaExcepcion ex) {
            ex.printStackTrace();
            fail("falla en persistencia");
        }
        assertNotSame(0, receta.getIdReceta());
    }
    @Test
    public void testConsultarReceta() {
        List<RecetaVO> result = new ArrayList<>();
        try {
            result = dao.getRecetas(null, null);
        } catch (PersistenciaExcepcion ex) {
            fail("Persistencia error");
        }
        assertNotSame(0, result.size());
    }
    
}
