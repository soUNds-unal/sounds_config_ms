package arquesoft.sounds_config_ms.controllers;

import java.util.List;
import java.util.Optional;

import arquesoft.sounds_config_ms.models.*;
import arquesoft.sounds_config_ms.repositories.*;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class ConfiguracionController {

    private final ConfiguracionRepository configuracionRepository;
    private final SuscripcionRepository suscripcionRepository;
    private final NotificacionRepository notificacionRepository;

    public ConfiguracionController(ConfiguracionRepository configuracionRepository,
            SuscripcionRepository suscripcionRepository,
            NotificacionRepository notificacionRepository) {

        this.configuracionRepository = configuracionRepository;
        this.suscripcionRepository = suscripcionRepository;
        this.notificacionRepository = notificacionRepository;

    }

    @PostMapping("/configuracion")
    Configuracion createConfiguracion(@RequestBody Configuracion configuracion) {
        Suscripcion suscripcion = this.suscripcionRepository.findById(configuracion.getSuscripcion().getIdSuscripcion())
                .orElse(null);
        Notificacion notificacion = this.notificacionRepository
                .findById(configuracion.getNotificacion().getIdNotificacion()).orElse(null);

        if (suscripcion == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "no existe plan");
        }
        if (notificacion == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "no existe la notificacion");
        }
        return this.configuracionRepository.save(configuracion);
    }

    @GetMapping("/configuraciones")
    List<Configuracion> getConfiguraciones() {
        return this.configuracionRepository.findAll();
    }

    @DeleteMapping("/deleteConfig/{idConfig}")
    public Configuracion deleteConfig(@PathVariable String idConfig) {
        Configuracion configuracion = this.configuracionRepository.findByRegexConfig(idConfig);
        if (configuracion == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se encontro una configuracion con id: " + idConfig);
        }
        this.configuracionRepository.deleteById(idConfig);
        return configuracion;

    }

    @PutMapping("updateConfig/{idConfig}")
    public Configuracion putConfig(@PathVariable String idConfig, @RequestBody Configuracion configuracion){
        Optional<Configuracion> configData = configuracionRepository.findById(idConfig);
        if(!configData.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se encontra la configuracion con id: "+idConfig);
        }else{
            if(!configData.isEmpty()){
                Configuracion _configuracion=configData.get();
                _configuracion.setPrivacidad(configuracion.getPrivacidad());
                _configuracion.setSuscripcion(configuracion.getSuscripcion());
                _configuracion.setNotificacion(configuracion.getNotificacion());
                configuracionRepository.save(_configuracion);  

                return _configuracion;
            }else{
                throw new ResponseStatusException(HttpStatus.NOT_FOUND,"no existe"+idConfig);

            }
        }     

    }

}
