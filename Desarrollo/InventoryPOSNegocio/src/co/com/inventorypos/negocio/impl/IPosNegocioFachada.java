/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.inventorypos.negocio.impl;

import co.com.inventorypos.comun.enums.EnumFuncionalidades;
import co.com.inventorypos.comun.enums.EnumPerfil;
import co.com.inventorypos.negocio.IIPosNegocioFachada;
import co.com.inventorypos.negocio.NegocioExcepcion;
import co.com.inventorypos.persistencia.IIPosPersistenciaFachada;
import co.com.inventorypos.persistencia.PersistenciaExcepcion;
import co.com.inventorypos.persistencia.impl.IPosPersistenciaFachada;
import java.util.List;

/**
 *
 * @author FernandoMora
 */
public class IPosNegocioFachada implements IIPosNegocioFachada{
    
    private static IIPosNegocioFachada instancia;
    private final IIPosPersistenciaFachada persistencia;
    
    public static IIPosNegocioFachada getInstancia(){
        if( instancia == null )
            instancia = new IPosNegocioFachada();
        return instancia;
    }

    private IPosNegocioFachada() {
        persistencia = IPosPersistenciaFachada.getInstancia();
    }
    

    @Override
    public EnumPerfil verificarCredenciales(String usuario, String password) throws NegocioExcepcion {
        try {
            if( (Object)usuario == null || usuario.isEmpty() 
                    || (Object)password == null || password.isEmpty() ){
                return null;
            }
            return persistencia.validarUsuario(usuario, password);
        } catch (PersistenciaExcepcion ex) {
            throw new NegocioExcepcion(ex.getMessage());
        }
    }

    @Override
    public List<EnumFuncionalidades> getFuncionalidades(EnumPerfil perfil) throws NegocioExcepcion {
        if( perfil == null ){
            throw new NegocioExcepcion("perfil es null");
        }
        try {
            return persistencia.getFuncionalidades(perfil);
        } catch (PersistenciaExcepcion ex) {
            throw new NegocioExcepcion(ex.getMessage());
        } catch(Exception e){
            throw new NegocioExcepcion();
        }
    }
    
}
