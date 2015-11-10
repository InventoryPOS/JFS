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
        connection.closeConnection();
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
        try {
            insumoDAO.crearInsumo(insumo);
        } catch (PersistenciaExcepcion ex) {
            ex.printStackTrace();
            fail("Error en persistencia");
        }
        assertNotSame(0, insumo.getIdInsumo());
        assertTrue(true);
    }

    /**
     * Test of actualizarInsumo method, of class InsumoDAO.
     */
    @Test
    public void testActualizarInsumo() {
        System.out.println("actualizarInsumo");
        InsumoVO insumo = new InsumoVO();
        insumo.setCodInsumo("cod_pr");
        insumo.setNombre("act de test");
        UnidadMedidaVO unidad= new UnidadMedidaVO();
        unidad.setUnidadMedidaId(1);
        insumo.setUnidad(unidad);
        try {
            insumoDAO.crearInsumo(insumo);
            System.out.println("Id de insumo: "+insumo.getIdInsumo());
            insumo.setCantidad(101);
            insumo.setNivelMinimo(20);
            insumo.setNivelOptimo(20);
            insumoDAO.actualizarInsumo(insumo);
        } catch (PersistenciaExcepcion ex) {
            ex.printStackTrace();
            fail("Error en persistencia");
        }
        assertTrue(true);
    }

    /**
     * Test of getInsumos method, of class InsumoDAO.
     */
    @Test
    public void testGetInsumos()  {
        System.out.println("getInsumos");
        List<InsumoVO> result = null;
        try {
            result = insumoDAO.getInsumos();
        } catch (PersistenciaExcepcion ex) {
            ex.printStackTrace();
            fail("Error en persistencia");
        }
        int expResult = 0;
        assertNotSame(expResult, result.size());
    }
    /**
     * Test of getInsumos method, of class InsumoDAO.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetInsumosFiltro() throws Exception {
        System.out.println("testGetInsumosFiltro");
        List<InsumoVO> result = insumoDAO.getInsumos(null,"1");
        assertSame(1, result.size());
        result = insumoDAO.getInsumos(null,"insumo 1");
        assertSame(1, result.size());
    }
    
}
