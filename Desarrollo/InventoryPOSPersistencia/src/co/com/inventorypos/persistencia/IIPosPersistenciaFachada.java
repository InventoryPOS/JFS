/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.inventorypos.persistencia;

import co.com.inventorypos.comun.enums.EnumFuncionalidades;
import co.com.inventorypos.comun.enums.EnumPerfil;
import java.util.List;

/**
 *
 * @author FernandoMora
 */
public interface IIPosPersistenciaFachada {
    /**
     * Si el usuario y password son validos, retorna el perfil asociado.<br>
     * Retorna <code>null</code> cuando no es valida la credencial
     * @param usuario
     * @param password
     * @return 
     * @throws co.com.inventorypos.persistencia.PersistenciaExcepcion 
     */
    public EnumPerfil validarUsuario(String usuario, String password) throws PersistenciaExcepcion;
    /**
     * Retorna la lista de Funcionalidades del perfil recibido por parametro
     * @param perfil
     * @return
     * @throws PersistenciaExcepcion 
     */
    public List<EnumFuncionalidades> getFuncionalidades(EnumPerfil perfil) throws PersistenciaExcepcion;
}
