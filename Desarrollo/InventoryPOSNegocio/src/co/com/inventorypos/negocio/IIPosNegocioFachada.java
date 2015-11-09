/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.inventorypos.negocio;

import co.com.inventorypos.comun.enums.EnumFuncionalidades;
import co.com.inventorypos.comun.enums.EnumPerfil;
import co.com.inventorypos.comun.vo.InsumoVO;
import java.util.List;

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
     * @throws co.com.inventorypos.negocio.NegocioExcepcion 
     */
    public EnumPerfil verificarCredenciales(String usuario, String password) throws NegocioExcepcion;
    /**
     * Retorna la lista de Funcionalidades del perfil recibido por parametro
     * @param perfil
     * @return 
     * @throws co.com.inventorypos.negocio.NegocioExcepcion 
     */
    public List<EnumFuncionalidades> getFuncionalidades(EnumPerfil perfil) throws NegocioExcepcion;
    /**
     * 
     * @return
     * @throws NegocioExcepcion 
     */
    public List<InsumoVO> getInsumos() throws NegocioExcepcion;
    /**
     * 
     * @param codigo
     * @param nombre
     * @return
     * @throws NegocioExcepcion 
     */
    public List<InsumoVO> getInsumos(String codigo, String nombre) throws NegocioExcepcion;
    /**
     * 
     * @param insumo
     * @throws NegocioExcepcion 
     */
    public void actualizarInsumo(InsumoVO insumo) throws NegocioExcepcion;
    /**
     * 
     * @param insumo
     * @throws NegocioExcepcion 
     */
    public void crearInsumo(InsumoVO insumo) throws NegocioExcepcion;
}
