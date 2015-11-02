/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.inventorypos.presentacion.web;

import co.com.inventorypos.comun.enums.EnumFuncionalidades;
import co.com.inventorypos.comun.enums.EnumPerfil;
import co.com.inventorypos.negocio.NegocioExcepcion;
import co.com.inventorypos.negocio.impl.IPosNegocioFachada;
import java.util.ArrayList;

/**
 *
 * @author V5
 */
public class UsuarioBeanVista {

    private String nombre;
    private String contrasena;
    private String outMessage;
    private String outMessageInvalid;
    private ArrayList<EnumFuncionalidades> funcionalidades;
    
    
    /**
     * Lista de funcionalidades según perfil 
     * @return 
     */
    public ArrayList<EnumFuncionalidades> getFuncionalidades() {
        return funcionalidades;
    }
    
    
    /**
     * Atributo outMessage
     * @return 
     */
    public String getOutMessage() {
        return outMessage;
    }
    /**
     * Atributo mensaje invalido
     * @return 
     */
    public String getOutMessageInvalid() {
        return outMessageInvalid;
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
        outMessageInvalid ="";
        EnumPerfil verificarCredenciales = null;
        
        try {
            verificarCredenciales = IPosNegocioFachada.getInstancia().verificarCredenciales(getNombre(), getContrasena());
            
            if (verificarCredenciales != null) {
                funcionalidades = (ArrayList<EnumFuncionalidades>) IPosNegocioFachada.getInstancia().getFuncionalidades(verificarCredenciales);
                outMessage = getNombre();
                return "exito";
            } else {
                outMessageInvalid="Credenciales incorrectas";
            }
        } catch (NegocioExcepcion ex){
            outMessageInvalid=ex.getMessage();
        }
            return "fracaso";
    }
    

}
