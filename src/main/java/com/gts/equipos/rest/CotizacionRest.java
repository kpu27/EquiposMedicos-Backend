/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gts.equipos.rest;


import com.gts.equipos.modelo.Cotizacion;
import com.gts.equipos.service.CotizacionService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author laszlo
 */
@RestController
@RequestMapping("/rest/v1/")
@CrossOrigin(origins={"http://localhost:4200","*"})

public class CotizacionRest {
     @Autowired
     private CotizacionService service;
     
    @GetMapping ("/cotizaciones/list")
    public List<Cotizacion> findAll(){
        return service.findAllCotizaciones();
    }  
    
    @GetMapping ("/cotizaciones/{id}" )
    public Optional<Cotizacion> findById(@PathVariable("id") Integer id  ){
        return service.findCotizacionById(id);
    }   
    
    @RequestMapping (value="/cotizaciones/new", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE  )
    public Cotizacion createCotizacion(@RequestBody Cotizacion cotizacion  ){
        return service.createCotizacion(cotizacion);
    }   
    
    @GetMapping ("/cotizaciones/activas/{idEmpresa}" )
    public List<Cotizacion> findCotizacionesClientesActivos(@PathVariable("idEmpresa") Integer idEmpresa ){
        return service.findCotizacionesClientesActivos(idEmpresa);
    } 
    
    @GetMapping ("/cotizaciones/medioDePago/list" )
    public List<String> condicionPago() {
        return service.metodosDePago();
    }
     
}
