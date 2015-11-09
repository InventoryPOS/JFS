/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.inventorypos.persistencia.dao;

import co.com.inventorypos.comun.vo.InsumoVO;
import co.com.inventorypos.comun.vo.UnidadMedidaVO;
import co.com.inventorypos.persistencia.AdminConnection;
import co.com.inventorypos.persistencia.PersistenciaExcepcion;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author FernandoMora
 */
public class InsumoDAOTest {
    private InsumoDAO insumoDAO;
    private AdminConnection connection;
    
    public InsumoDAOTest() {
    }
    
    @Before
    public void setUp() {
        connection = new AdminConnection();
        try {
            connection.createConnection();
        } catch (PersistenciaExcepcion ex) {
        }
        insumoDAO = new InsumoDAO(connection.getConnection());
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of crearInsumo method, of class InsumoDAO.
     */
    @Test
    public void testCrearInsumo() {
        System.out.println("crearInsumo");
        InsumoVO insumo = new InsumoVO();
        insumo.setCodInsumo("cod_pr");
        insumo.setNombre("insumo de test");
        UnidadMedidaVO unidad= new UnidadMedidaVO();
        unidad.setUnidadMedidaId(1);
        insumo.setUnidad(unidad);
        insumoDAO.crearInsumo(insumo);
        assertNotSame(0, insumo.getIdInsumo());
    }

    /**
     * Test of actualizarInsumo method, of class InsumoDAO.
     */
    @Test
    public void testActualizarInsumo() {
        System.out.println("actualizarInsumo");
        InsumoVO insumo = null;
        insumoDAO.actualizarInsumo(insumo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInsumos method, of class InsumoDAO.
     */
    @Test
    public void testGetInsumos() throws Exception {
        System.out.println("getInsumos");
        List<InsumoVO> result = insumoDAO.getInsumos();
        int expResult = 0;
        assertNotSame(expResult, result.size());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
