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
public class InsumoBeanVista {
    /**
     * Atributos del insumo 
     */
    private String nombreInsumo;
    private int codigoInsumo;
    private String unidadInsumo;
    private int cantidadInsumo;
    private String descripcion;

    public String getNombreInsumo() {
        return nombreInsumo;
    }

    public int getCodigoInsumo() {
        return codigoInsumo;
    }

    public String getUnidadInsumo() {
        return unidadInsumo;
    }

    public int getCantidadInsumo() {
        return cantidadInsumo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setNombreInsumo(String nombreInsumo) {
        this.nombreInsumo = nombreInsumo;
    }

    public void setCodigoInsumo(int codigoInsumo) {
        this.codigoInsumo = codigoInsumo;
    }

    public void setUnidadInsumo(String unidadInsumo) {
        this.unidadInsumo = unidadInsumo;
    }

    public void setCantidadInsumo(int cantidadInsumo) {
        this.cantidadInsumo = cantidadInsumo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
}
