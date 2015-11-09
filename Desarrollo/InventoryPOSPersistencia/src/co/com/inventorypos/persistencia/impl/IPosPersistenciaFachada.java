/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.inventorypos.persistencia.impl;

import co.com.inventorypos.comun.enums.EnumFuncionalidades;
import co.com.inventorypos.comun.enums.EnumPerfil;
import co.com.inventorypos.comun.vo.InsumoVO;
import co.com.inventorypos.comun.vo.UnidadMedidaVO;
import co.com.inventorypos.persistencia.AdminConnection;
import co.com.inventorypos.persistencia.IIPosPersistenciaFachada;
import co.com.inventorypos.persistencia.PersistenciaExcepcion;
import co.com.inventorypos.persistencia.dao.CredencialesDAO;
import co.com.inventorypos.persistencia.dao.InsumoDAO;
import co.com.inventorypos.persistencia.dao.UnidadMedidaDAO;
import java.util.Date;
import java.util.List;

/**
 *
 * @author FernandoMora
 */
public class IPosPersistenciaFachada implements IIPosPersistenciaFachada{
    private static IIPosPersistenciaFachada instancia;
    private final AdminConnection adminConnection;
    private CredencialesDAO credencialesDAO;
    private UnidadMedidaDAO unidadMedidaDAO;
    private InsumoDAO insumoDAO;

    private IPosPersistenciaFachada() {
        adminConnection = new AdminConnection();
        try {
            adminConnection.createConnection();
            credencialesDAO = new CredencialesDAO(adminConnection.getConnection());
            unidadMedidaDAO = new UnidadMedidaDAO(adminConnection.getConnection());
            insumoDAO = new InsumoDAO(adminConnection.getConnection());
        } catch (PersistenciaExcepcion ex) {
        }
    }
    
    public static IIPosPersistenciaFachada getInstancia(){
        if( instancia == null ){
            instancia = new IPosPersistenciaFachada();
        }
        return instancia;
    }

    @Override
    public EnumPerfil validarUsuario(String usuario, String password) throws PersistenciaExcepcion {
        EnumPerfil perfil = credencialesDAO.verificarCredenciales(usuario, password);
        return perfil;
    }
    @Override
    public List<EnumFuncionalidades> getFuncionalidades(EnumPerfil perfil) throws PersistenciaExcepcion {
        List<EnumFuncionalidades> funcionalidades = credencialesDAO.getFuncionalidades(perfil);
        return funcionalidades;
    }

    @Override
    public List<UnidadMedidaVO> getUnidadesMedida() throws PersistenciaExcepcion {
        List<UnidadMedidaVO> listaUnidadesDeMedida = unidadMedidaDAO.getUnidadesMedida();
        return listaUnidadesDeMedida;
    }

    @Override
    public void crearInsumo(InsumoVO insumo) throws PersistenciaExcepcion {
        throw new PersistenciaExcepcion("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<InsumoVO> getInsumos() throws PersistenciaExcepcion {
        List<InsumoVO> lista = insumoDAO.getInsumos();
        return lista;
    }

    @Override
    public void actualizarInsumo(InsumoVO insumo) throws PersistenciaExcepcion {
        throw new PersistenciaExcepcion("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<InsumoVO> getInsumosConsumidos(Date fechaInicial, Date fechaFinal) throws PersistenciaExcepcion {
        throw new PersistenciaExcepcion("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<InsumoVO> getInsumos(String codigo, String nombre) throws PersistenciaExcepcion {
        List<InsumoVO> lista = insumoDAO.getInsumos(codigo,nombre);
        return lista;
    }
}
