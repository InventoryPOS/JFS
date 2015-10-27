/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.inventorypos.negocio;

import co.com.inventorypos.comun.enums.EnumPerfil;

/**
 *
 * @author FernandoMora
 */
public interface IIPosNegocioFachada {
    /**
     * Si el usuario y password no son validos, entonces retorna null<br>
     * Si las credenciales son validas, entonces retorna el perfil asociado.
     * @param usuario
     * @param password
     * @return 
     */
    public EnumPerfil verificarCredenciales(String usuario, String password);
}
