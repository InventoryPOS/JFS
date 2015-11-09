/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.inventorypos.persistencia;

import co.com.inventorypos.comun.enums.EnumFuncionalidades;
import co.com.inventorypos.comun.enums.EnumPerfil;
import co.com.inventorypos.comun.vo.InsumoVO;
import co.com.inventorypos.comun.vo.UnidadMedidaVO;
import java.util.Date;
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
    /**
     * retorna la lista de las Unidades de medida
     * @return
     * @throws PersistenciaExcepcion 
     */
    public List<UnidadMedidaVO> getUnidadesMedida() throws PersistenciaExcepcion;
    /**
     * 
     * @param insumo
     * @throws PersistenciaExcepcion 
     */
    public void crearInsumo(InsumoVO insumo) throws PersistenciaExcepcion;
    /**
     * 
     * @return
     * @throws PersistenciaExcepcion 
     */
    public List<InsumoVO> getInsumos() throws PersistenciaExcepcion;
    /**
     * 
     * @param codigo
     * @param nombre
     * @return
     * @throws PersistenciaExcepcion 
     */
    public List<InsumoVO> getInsumos(String codigo,String nombre) throws PersistenciaExcepcion;
    /**
     * 
     * @param insumo
     * @throws PersistenciaExcepcion 
     */
    public void actualizarInsumo(InsumoVO insumo) throws PersistenciaExcepcion;
    /**
     * 
     * @param fechaInicial
     * @param fechaFinal
     * @return
     * @throws PersistenciaExcepcion 
     */
    public List<InsumoVO> getInsumosConsumidos(Date fechaInicial, Date fechaFinal) throws PersistenciaExcepcion;
}
