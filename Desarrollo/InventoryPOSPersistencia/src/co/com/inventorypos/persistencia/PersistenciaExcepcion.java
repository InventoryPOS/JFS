/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.inventorypos.persistencia;

/**
 *
 * @author FernandoMora
 */
public class PersistenciaExcepcion extends Exception{
    private static String error = "Error en base de datos";

    public PersistenciaExcepcion(Throwable cause) {
        super(error, cause);
    }

    public PersistenciaExcepcion() {
        super(error);
    }

    public PersistenciaExcepcion(String message) {
        super(message);
    }
    
}
