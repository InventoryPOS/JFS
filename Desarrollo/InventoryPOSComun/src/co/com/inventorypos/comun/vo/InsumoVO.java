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
public class InsumoVO {
    private int idInsumo;
    private String codInsumo;
    private String nombre;
    private double cantidad;
    private String descripcion;
    private double nivelMinimo;
    private double nivelOptimo;
    private UnidadMedida unidad;

    public int getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(int idInsumo) {
        this.idInsumo = idInsumo;
    }

    public String getCodInsumo() {
        return codInsumo;
    }

    public void setCodInsumo(String codInsumo) {
        this.codInsumo = codInsumo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getNivelMinimo() {
        return nivelMinimo;
    }

    public void setNivelMinimo(double nivelMinimo) {
        this.nivelMinimo = nivelMinimo;
    }

    public double getNivelOptimo() {
        return nivelOptimo;
    }

    public void setNivelOptimo(double nivelOptimo) {
        this.nivelOptimo = nivelOptimo;
    }

    public UnidadMedida getUnidad() {
        return unidad;
    }

    public void setUnidad(UnidadMedida unidad) {
        this.unidad = unidad;
    }
    
    
}
