/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.inventorypos.comun.vo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author FernandoMora
 */
public class RecetaVO {
    private int idReceta;
    private String nombre;
    private String descripcion;
    private List<IngredienteVO> ingredientes;

    public RecetaVO() {
        ingredientes = new ArrayList<>();
    }

    public int getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(int idReceta) {
        this.idReceta = idReceta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<IngredienteVO> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<IngredienteVO> ingredientes) {
        this.ingredientes = ingredientes;
    }
    
}
