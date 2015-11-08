/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.inventorypos.negocio.impl;

import co.com.inventorypos.comun.vo.InsumoVO;
import co.com.inventorypos.negocio.IIPosNegocioFachada;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

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
    
}
