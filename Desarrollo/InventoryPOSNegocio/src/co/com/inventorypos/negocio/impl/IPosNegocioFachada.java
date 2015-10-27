/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.inventorypos.negocio.impl;

import co.com.inventorypos.comun.enums.EnumPerfil;
import co.com.inventorypos.negocio.IIPosNegocioFachada;

/**
 *
 * @author FernandoMora
 */
public class IPosNegocioFachada implements IIPosNegocioFachada{
    
    private IIPosNegocioFachada instancia;
    
    public IIPosNegocioFachada getInstancia(){
        if( instancia == null )
            instancia = new IPosNegocioFachada();
        return instancia;
    }

    private IPosNegocioFachada() {
    }
    

    @Override
    public EnumPerfil verificarCredenciales(String usuario, String password) {
        if( (Object)usuario == null || usuario.isEmpty() ){
            return null;
        }
        if( usuario.toUpperCase().equalsIgnoreCase("CAJERO") ){
            return EnumPerfil.CAJERO;
        }
        if( usuario.toUpperCase().equalsIgnoreCase("ADMIN") ){
            return EnumPerfil.ADMINISTRADOR;
        }
        if( usuario.toUpperCase().equalsIgnoreCase("DESPACHADOR") ){
            return EnumPerfil.DESPACHADOR;
        }
        if( usuario.toUpperCase().equalsIgnoreCase("JEFE") ){
            return EnumPerfil.JEFE_ALMACEN;
        }
        return null;
    }
    
}
