/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.inventorypos.presentacion.web;

/**
 *
 * @author V5
 */
public class InsumoVistaBean {
    private String nombreInsumo;
    private int codigoInsumo;
    private int unidadInsumo;
    private int cantidadInsumo;

    /**
     * Atributos de los insumos
     * @return 
     */
    public String getNombreInsumo() {
        return nombreInsumo;
    }

    public void setNombreInsumo(String nombreInsumo) {
        this.nombreInsumo = nombreInsumo;
    }

    public int getCodigoInsumo() {
        return codigoInsumo;
    }

    public void setCodigoInsumo(int codigoInsumo) {
        this.codigoInsumo = codigoInsumo;
    }

    public int getUnidadInsumo() {
        return unidadInsumo;
    }

    public void setUnidadInsumo(int unidadInsumo) {
        this.unidadInsumo = unidadInsumo;
    }

    public int getCantidadInsumo() {
        return cantidadInsumo;
    }

    public void setCantidadInsumo(int cantidadInsumo) {
        this.cantidadInsumo = cantidadInsumo;
    }
    
    
}
