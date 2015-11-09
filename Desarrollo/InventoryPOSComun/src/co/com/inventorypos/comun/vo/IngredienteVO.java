/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.inventorypos.comun.vo;

/**
 *
 * @author FernandoMora
 */
public class IngredienteVO {
    private int idIngrediente;
    private double cantidad;
    private InsumoVO insumo;

    public IngredienteVO() {
        this.insumo = new InsumoVO();
    }

    public int getIdIngrediente() {
        return idIngrediente;
    }

    public void setIdIngrediente(int idIngrediente) {
        this.idIngrediente = idIngrediente;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public InsumoVO getInsumo() {
        return insumo;
    }

    public void setInsumo(InsumoVO insumo) {
        this.insumo = insumo;
    }
    
}
