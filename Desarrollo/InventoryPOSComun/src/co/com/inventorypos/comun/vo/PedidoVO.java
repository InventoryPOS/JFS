/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.inventorypos.comun.vo;

import java.util.Date;
import java.util.List;

/**
 *
 * @author FernandoMora
 */
public class PedidoVO {
    private int idPedido;
    private Date fechaPedido;
    private List<RecetaConsumidaVO> recetas;

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public List<RecetaConsumidaVO> getRecetas() {
        return recetas;
    }

    public void setRecetas(List<RecetaConsumidaVO> recetas) {
        this.recetas = recetas;
    }
    
}
