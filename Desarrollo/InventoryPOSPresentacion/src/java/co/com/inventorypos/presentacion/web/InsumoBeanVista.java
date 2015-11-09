/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.inventorypos.presentacion.web;

import co.com.inventorypos.comun.enums.EnumFuncionalidades;
import co.com.inventorypos.comun.vo.InsumoVO;
import co.com.inventorypos.negocio.NegocioExcepcion;
import co.com.inventorypos.negocio.impl.IPosNegocioFachada;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author V5
 */
public class InsumoBeanVista {
    /**
     * Atributos del insumo 
     */
    private String nombreInsumo;
    private String codigoInsumo;
    private String unidadInsumo;
    private int cantidadInsumo;
    private String descripcion;
    private ArrayList<InsumoVO> insumos;
    private String outMessage;
    private String outMessageInvalid;

    public String getOutMessageInvalid() {
        return outMessageInvalid;
    }
    
    

    public ArrayList<InsumoVO> getInsumos() {
        return insumos;
    }

    public String getOutMessage() {
        return outMessage;
    }
    
    

    public String getNombreInsumo() {
        return nombreInsumo;
    }

    public String getCodigoInsumo() {
        return codigoInsumo;
    }

    public void setCodigoInsumo(String codigoInsumo) {
        this.codigoInsumo = codigoInsumo;
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



    public void setUnidadInsumo(String unidadInsumo) {
        this.unidadInsumo = unidadInsumo;
    }

    public void setCantidadInsumo(int cantidadInsumo) {
        this.cantidadInsumo = cantidadInsumo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String consultarInsumos(){
        outMessage = "";
        outMessageInvalid ="";
        try {
         if(getNombreInsumo().equals("") || getCodigoInsumo().equals("")){
               outMessageInvalid ="Ingrese el nombre o el codigo para consultar un insumo";
               return "fracaso";
            }else{
              insumos =(ArrayList<InsumoVO>) IPosNegocioFachada.getInstancia().getInsumos(getCodigoInsumo(),getNombreInsumo());
              
            }
           
            
        } catch (NegocioExcepcion ex) {
            Logger.getLogger(InsumoBeanVista.class.getName()).log(Level.SEVERE, null, ex);
        }
    return "consultar";
    }

    
}
