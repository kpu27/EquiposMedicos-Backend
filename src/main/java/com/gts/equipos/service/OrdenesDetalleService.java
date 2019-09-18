package com.gts.equipos.service;

import com.gts.equipos.modelo.OrdenesDetalle;
import com.gts.equipos.repository.OrdenesDetalleRepository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdenesDetalleService {
    @Autowired
    private OrdenesDetalleRepository OrdenesDetalleDao;
    
    public List<OrdenesDetalle> findAllOrdenes(){
        return OrdenesDetalleDao.findAll();
    } 

    public Optional<OrdenesDetalle> findOrdenesById( Integer id){
        return OrdenesDetalleDao.findById(id);
    }
    public List<Object> findByIdEmpresa(Integer idEmpresa) {
        return OrdenesDetalleDao.listarByIdEmpresa(idEmpresa);
      }
    
    public List<Object> filterByVarios(Integer idEmpresa, Date fechai, Date fechaf){
    	return OrdenesDetalleDao.listarByEmpresaFecha(idEmpresa, fechai, fechaf); 
    }
    
    public List<Object> listarByEmpresaCliente(Integer idEmpresa, Date fechai, Date fechaf){
    	return OrdenesDetalleDao.listarByEmpresaCliente(idEmpresa, fechai, fechaf); 
    }
    
    public List<Object> listarByEmpresaResponsable2(Integer idEmpresa, Date fechai, Date fechaf){
    	return OrdenesDetalleDao.listarByEmpresaResponsable2(idEmpresa, fechai, fechaf); 
    }
    
     public List<Object> listarByEmpresaResponsabl(Integer idEmpresa, Date fechai, Date fechaf){
    	return OrdenesDetalleDao.listarByEmpresaResponsable(idEmpresa, fechai, fechaf); 
    }
    
    public OrdenesDetalle cretaeOrdenes( OrdenesDetalle orden){            
        return OrdenesDetalleDao.save(orden);
    }
    
    public String updateOrden( Integer idOrden, OrdenesDetalle orden){            
        if (OrdenesDetalleDao.findById(idOrden) == null)
        {
            return "El parametro no existe.";
        }
        else
        {
        	OrdenesDetalleDao.save(orden);
             return "Parametro actualizada.!";
        }      
    }

	public List<Object> listarByEmpresaResponsable(Integer idEmpresa, Date fechai, Date fechaf) {
		// TODO Auto-generated method stub
		return OrdenesDetalleDao.listarByEmpresaResponsable(idEmpresa, fechai, fechaf);
	}
    
}
