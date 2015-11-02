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
public class UnidadMedida {
    private int unidadMedidaId;
    private String codUnidadMedida;
    private String nombre;
    private String simbolo;
    private boolean permiteDecimales;

    public int getUnidadMedidaId() {
        return unidadMedidaId;
    }

    public void setUnidadMedidaId(int unidadMedidaId) {
        this.unidadMedidaId = unidadMedidaId;
    }

    public String getCodUnidadMedida() {
        return codUnidadMedida;
    }

    public void setCodUnidadMedida(String codUnidadMedida) {
        this.codUnidadMedida = codUnidadMedida;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public boolean isPermiteDecimales() {
        return permiteDecimales;
    }

    public void setPermiteDecimales(boolean permiteDecimales) {
        this.permiteDecimales = permiteDecimales;
    }
    
}
