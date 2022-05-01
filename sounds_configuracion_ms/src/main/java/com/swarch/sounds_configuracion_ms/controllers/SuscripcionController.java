package com.swarch.sounds_configuracion_ms.controllers;

import java.util.List;
import java.util.Optional;

import com.swarch.sounds_configuracion_ms.models.Suscripcion;
import com.swarch.sounds_configuracion_ms.repositories.SuscripcionRepository;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class SuscripcionController {

    private final SuscripcionRepository suscripcionRepository;

    public SuscripcionController(SuscripcionRepository suscripcionRepository ){
        this.suscripcionRepository =  suscripcionRepository;

    }

    @PostMapping("/suscripcion")
	public Suscripcion create(@RequestBody Suscripcion suscripcion) {
		return suscripcionRepository.save(suscripcion);
	}
    
    @GetMapping("/suscripciones")
    List<Suscripcion> getSuscripciones(@RequestParam("u") Optional<String> idSuscripcion){
        if(idSuscripcion.isPresent()){
            List<Suscripcion> listSuscripcion=this.suscripcionRepository.findByRegexIdSuscripcion(idSuscripcion.get());
            if(listSuscripcion.isEmpty()){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se encontraron Suscripciones");

            }
            return listSuscripcion;
        }
        else{
            return suscripcionRepository.findAll();
        }
    }
    
    @DeleteMapping("/deleteSuscripcion/{idSuscripcion}")
    public Suscripcion deltetSuscripcion(@PathVariable String idSuscripcion){
        Suscripcion suscripcion=this.suscripcionRepository.findByRegexSuscripcion(idSuscripcion);
        if(suscripcion==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se encontra la suscripcion con id: "+idSuscripcion);
        }
        this.suscripcionRepository.deleteById(idSuscripcion);
        return suscripcion;
    }

    @PutMapping("updateSuscripcion/{idSuscripcion}")
    public Suscripcion putSuscripcion(@PathVariable String idSuscripcion, @RequestBody Suscripcion suscripcion){
        Optional<Suscripcion> suscripcionData = suscripcionRepository.findById(idSuscripcion);
        if(!suscripcionData.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se encontra la suscripcion con id: "+idSuscripcion);
        }else{
            if(!suscripcionData.isEmpty()){
                Suscripcion _suscripcion=suscripcionData.get();
                _suscripcion.setNombre(suscripcion.getNombre());
                _suscripcion.setPrecio(suscripcion.getPrecio());
                _suscripcion.setDescripcion(suscripcion.getDescripcion());
                suscripcionRepository.save(_suscripcion);  

                return _suscripcion;
            }else{
                throw new ResponseStatusException(HttpStatus.NOT_FOUND,"xxxxxx"+idSuscripcion);

            }
        }     

    }
}
