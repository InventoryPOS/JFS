/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.inventorypos.presentacion.web;

import co.com.inventorypos.comun.enums.EnumPerfil;
import co.com.inventorypos.negocio.NegocioExcepcion;
import co.com.inventorypos.negocio.impl.IPosNegocioFachada;

/**
 *
 * @author V5
 */
public class UsuarioBeanVista {

    private String nombre;
    private String contrasena;
    private String outMessage;
    
    
    /**
     * Atributo outMessage
     * @return 
     */
    public String getOutMessage() {
        return outMessage;
    }

    /**
     * Atributo Nombre
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Atributo Contraseña
     *
     * @return
     */
    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String verificarCredenciales() {
        outMessage = "";
        EnumPerfil verificarCredenciales = null;
        try {
            verificarCredenciales = IPosNegocioFachada.getInstancia().verificarCredenciales(getNombre(), getContrasena());
            if (verificarCredenciales != null) {
                outMessage = verificarCredenciales.name();
                return "exito";
            } else {
                outMessage="Credenciales incorrectas";
            }
        } catch (NegocioExcepcion ex){
            outMessage=ex.getMessage();
        }
            return "fracaso";
    }

}
