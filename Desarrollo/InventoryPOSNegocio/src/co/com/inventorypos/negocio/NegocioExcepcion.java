/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.inventorypos.negocio;

/**
 *
 * @author FernandoMora
 */
public class NegocioExcepcion extends Exception{
    private static String error = "Error en capa de Negocio";

    public NegocioExcepcion() {
        super(error);
    }

    public NegocioExcepcion(String message) {
        super(message);
    }

    public NegocioExcepcion(Throwable cause) {
        super(error, cause);
    }
    
}
