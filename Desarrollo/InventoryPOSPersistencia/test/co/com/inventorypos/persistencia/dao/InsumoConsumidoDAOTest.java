/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.inventorypos.persistencia.dao;

import co.com.inventorypos.comun.vo.InsumoConsumidoVO;
import co.com.inventorypos.persistencia.AdminConnection;
import co.com.inventorypos.persistencia.PersistenciaExcepcion;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author FernandoMora
 */
public class InsumoConsumidoDAOTest {
    private AdminConnection connection;
    private InsumoConsumidoDAO dao;
    
    public InsumoConsumidoDAOTest() {
    }
    
    @Before
    public void setUp() {
        connection = new AdminConnection();
        try {
            connection.createConnection();
        } catch (PersistenciaExcepcion ex) {
        }
        dao = new InsumoConsumidoDAO(connection.getConnection());
    }
    
    @After
    public void tearDown() {
        connection.closeConnection();
    }

    /**
     * Test of getInsumos method, of class InsumoConsumidoDAO.
     */
    @Test
    public void testGetInsumosConsumidos(){
        System.out.println("getInsumos");
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
        String strFecha = "2007-12-25";
        Date fecha = new Date();

        try {
            fecha = formatoDelTexto.parse(strFecha);
        } catch (ParseException ex) {
            fail("Error en persistencia al crear fecha inicial");
        }
        Date fechaInicial = fecha;
        Date fechaFinal = new Date();
        List<InsumoConsumidoVO> result = null;
        try {
            result = this.dao.getInsumosConsumidos(fechaInicial, fechaFinal);
        } catch (PersistenciaExcepcion ex) {
            ex.printStackTrace();
            fail("Error en persistencia");
        }
        assertNotSame(0, result.size());
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
