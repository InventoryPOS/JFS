/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.inventorypos.comun.vo;

import java.util.Date;

/**
 *
 * @author FernandoMora
 */
public class InsumoConsumidoVO {
    private int idInsumoConsumo;
    private double cantidad;
    private Date fechaConsumo;
    private InsumoVO insumo;

    public InsumoConsumidoVO() {
        this.insumo = new InsumoVO();
    }

    public int getIdInsumoConsumo() {
        return idInsumoConsumo;
    }

    public void setIdInsumoConsumo(int idInsumoConsumo) {
        this.idInsumoConsumo = idInsumoConsumo;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFechaConsumo() {
        return fechaConsumo;
    }

    public void setFechaConsumo(Date fechaConsumo) {
        this.fechaConsumo = fechaConsumo;
    }

    public InsumoVO getInsumo() {
        return insumo;
    }

    public void setInsumo(InsumoVO insumo) {
        this.insumo = insumo;
    }
    
}
