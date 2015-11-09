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
public class RecetaConsumidaVO {
    private int idRecetaConsumida;
    private double cantidad;
    private int idPedido;
    private RecetaVO receta;

    public RecetaConsumidaVO() {
        receta = new RecetaVO();
    }

    public int getIdRecetaConsumida() {
        return idRecetaConsumida;
    }

    public void setIdRecetaConsumida(int idRecetaConsumida) {
        this.idRecetaConsumida = idRecetaConsumida;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public RecetaVO getReceta() {
        return receta;
    }

    public void setReceta(RecetaVO receta) {
        this.receta = receta;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }
    
}
