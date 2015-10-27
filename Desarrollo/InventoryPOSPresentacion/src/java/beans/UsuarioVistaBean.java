/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author V5
 */
public class UsuarioVistaBean {
    private String nombre;
    private String contrasena;
   
    //Atributo Nombre
    public void setNombre(String nuevoNombre){
        nombre = nuevoNombre;
    }
    public String getNombre(){
        return nombre;
    }
   
    //Atributo contrasena
    public void setContrasena(String nuevaContrasena){
        contrasena = nuevaContrasena;
    }
    public String getContrasena(){
        return contrasena;
    }  
   
}
