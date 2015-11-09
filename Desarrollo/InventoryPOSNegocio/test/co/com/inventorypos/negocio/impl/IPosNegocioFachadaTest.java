/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.inventorypos.negocio.impl;

import co.com.inventorypos.comun.enums.EnumFuncionalidades;
import co.com.inventorypos.comun.enums.EnumPerfil;
import co.com.inventorypos.comun.vo.InsumoVO;
import co.com.inventorypos.negocio.IIPosNegocioFachada;
import java.util.List;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author FernandoMora
 */
public class IPosNegocioFachadaTest {
    private IIPosNegocioFachada negocioFachada;
    public IPosNegocioFachadaTest() {
    }
    
    @Before
    public void setUp() {
        negocioFachada = IPosNegocioFachada.getInstancia();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getInsumos method, of class IPosNegocioFachada.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetInsumos() throws Exception {
        System.out.println("getInsumos");
        List<InsumoVO> result = negocioFachada.getInsumos();
        assertNotSame(0, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getInstancia method, of class IPosNegocioFachada.
     */
    @org.junit.Test
    public void testGetInstancia() {
        System.out.println("getInstancia");
        IIPosNegocioFachada expResult = null;
        IIPosNegocioFachada result = IPosNegocioFachada.getInstancia();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verificarCredenciales method, of class IPosNegocioFachada.
     */
    @org.junit.Test
    public void testVerificarCredenciales() throws Exception {
        System.out.println("verificarCredenciales");
        String usuario = "";
        String password = "";
        IPosNegocioFachada instance = null;
        EnumPerfil expResult = null;
        EnumPerfil result = instance.verificarCredenciales(usuario, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFuncionalidades method, of class IPosNegocioFachada.
     */
    @org.junit.Test
    public void testGetFuncionalidades() throws Exception {
        System.out.println("getFuncionalidades");
        EnumPerfil perfil = null;
        IPosNegocioFachada instance = null;
        List<EnumFuncionalidades> expResult = null;
        List<EnumFuncionalidades> result = instance.getFuncionalidades(perfil);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInsumos method, of class IPosNegocioFachada.
     */
    @org.junit.Test
    public void testGetInsumos_0args() throws Exception {
        System.out.println("getInsumos");
        IPosNegocioFachada instance = null;
        List<InsumoVO> expResult = null;
        List<InsumoVO> result = instance.getInsumos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInsumos method, of class IPosNegocioFachada.
     */
    @org.junit.Test
    public void testGetInsumos_String_String() throws Exception {
        System.out.println("getInsumos");
        String codigo = "";
        String nombre = "";
        IPosNegocioFachada instance = null;
        List<InsumoVO> expResult = null;
        List<InsumoVO> result = instance.getInsumos(codigo, nombre);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actualizarInsumo method, of class IPosNegocioFachada.
     */
    @org.junit.Test
    public void testActualizarInsumo() throws Exception {
        System.out.println("actualizarInsumo");
        InsumoVO insumo = null;
        IPosNegocioFachada instance = null;
        instance.actualizarInsumo(insumo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of crearInsumo method, of class IPosNegocioFachada.
     */
    @org.junit.Test
    public void testCrearInsumo() throws Exception {
        System.out.println("crearInsumo");
        InsumoVO insumo = null;
        IPosNegocioFachada instance = null;
        instance.crearInsumo(insumo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
