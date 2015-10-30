/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.inventorypos.presentacion.web;

import co.com.inventorypos.negocio.impl.IPosNegocioFachada;

/**
 *
 * @author V5
 */
public class LoginBean {
     
        UsuarioVistaBean usuario;
        public void autenticar(){
          IPosNegocioFachada.getInstancia().verificarCredenciales(usuario.getNombre(), usuario.getContrasena());
    }
}
