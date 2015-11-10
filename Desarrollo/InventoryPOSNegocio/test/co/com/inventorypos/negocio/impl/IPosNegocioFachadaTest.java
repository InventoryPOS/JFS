/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.inventorypos.negocio.impl;

import co.com.inventorypos.comun.enums.EnumPerfil;
import co.com.inventorypos.comun.vo.InsumoVO;
import co.com.inventorypos.negocio.IIPosNegocioFachada;
import java.util.List;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
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
        assertNotSame(expResult, result);
    }

    /**
     * Test of verificarCredenciales method, of class IPosNegocioFachada.
     */
    @org.junit.Test
    public void testVerificarCredenciales() throws Exception {
        System.out.println("verificarCredenciales");
        String usuario = "";
        String password = "";
        EnumPerfil expResult = null;
        EnumPerfil result = negocioFachada.verificarCredenciales(usuario, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }


    /**
     * Test of getInsumos method, of class IPosNegocioFachada.
     */
    @org.junit.Test
    public void testGetInsumos_0args() throws Exception {
        System.out.println("getInsumos");
        List<InsumoVO> result = negocioFachada.getInsumos();
        assertNotSame(0, result.size());
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getInsumos method, of class IPosNegocioFachada.
     */
    @org.junit.Test
    public void testGetInsumos_String_String() throws Exception {
        System.out.println("getInsumos");
        String codigo = null;
        String nombre = "1";
        List<InsumoVO> result = negocioFachada.getInsumos(codigo, nombre);
        assertEquals(1, result.size());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

}
