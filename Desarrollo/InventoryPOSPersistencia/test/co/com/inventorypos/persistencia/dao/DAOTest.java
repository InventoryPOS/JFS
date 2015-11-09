/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.inventorypos.persistencia.dao;

import co.com.inventorypos.comun.enums.EnumFuncionalidades;
import co.com.inventorypos.comun.enums.EnumPerfil;
import co.com.inventorypos.comun.vo.UnidadMedidaVO;
import co.com.inventorypos.persistencia.AdminConnection;
import co.com.inventorypos.persistencia.PersistenciaExcepcion;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author FernandoMora
 */
public class DAOTest {
    private Connection connection;
    
    public DAOTest() {
    }
    
    @Before
    public void setUp() {
        AdminConnection con = new AdminConnection();
        
        try {
            con.createConnection();
            connection = con.getConnection();
            System.out.println("Conexion de prueba OK");
        } catch (PersistenciaExcepcion ex) {
            ex.printStackTrace();
        }
    }
    
    @After
    public void tearDown() {
        try {
            connection.close();
            System.out.println("Conexion de prueba Cerrada");
        } catch (SQLException ex) {
        }
    }

    /**
     * Test of verificarCredenciales method, of class UsuarioDAO.
     */
    @Test
    public void testVerificarCredenciales() throws Exception {
        System.out.println("verificarCredenciales");
        String usuario = "ADMIN";
        String password = "1234";
        CredencialesDAO instance = new CredencialesDAO(connection);
        EnumPerfil expResult = EnumPerfil.ADMINISTRADOR;
        EnumPerfil result = instance.verificarCredenciales(usuario, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    /**
     * Test of verificarCredenciales method, of class UsuarioDAO.
     */
    @Test
    public void testVerificarCredencialesFail() throws Exception {
        System.out.println("testVerificarCredencialesFail");
        String usuario = "admin";
        String password = "1234";
        CredencialesDAO instance = new CredencialesDAO(connection);
        EnumPerfil expResult = null;
        EnumPerfil result = instance.verificarCredenciales(usuario, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    @Test
    public void testFuncionalidadesPorPerfil() throws Exception{
        System.out.println("testFuncionalidadesPorPerfil");
        
        CredencialesDAO instance = new CredencialesDAO(connection);
        List<EnumFuncionalidades> listaCajero = new ArrayList<>();
        listaCajero.add(EnumFuncionalidades.RECETAS_CONSULTAS);
        listaCajero.add(EnumFuncionalidades.PEDIDOS_REGISTRO);
        List<EnumFuncionalidades> funcionalidades = instance.getFuncionalidades(EnumPerfil.CAJERO);
        assertEquals(listaCajero, funcionalidades);
    }
    @Test
    public void testUnidadesMedida() throws Exception{
        System.out.println("testUnidadesMedida");
        
        UnidadMedidaDAO instance = new UnidadMedidaDAO(connection);
        List<UnidadMedidaVO> lista = instance.getUnidadesMedida();
        assertNotSame(0, lista.size());
    }
    
}
