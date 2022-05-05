package arquesoft.sounds_config_ms.controllers;

import java.util.List;
import java.util.Optional;

import arquesoft.sounds_config_ms.models.Notificacion;
import arquesoft.sounds_config_ms.repositories.NotificacionRepository;

import org.springframework.beans.factory.annotation.Autowired;
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
public class NotificacionController {

    @Autowired
    NotificacionRepository notificacionRepository;

    @PostMapping("/notificacion")
	public Notificacion createNotificacion(@RequestBody Notificacion notificacion) {
		return notificacionRepository.save(notificacion);
	}

    @GetMapping("/notificaciones")
	List<Notificacion> getNotificaciones(){
		return this.notificacionRepository.findAll();
	}

    @DeleteMapping("/deleteNotificacion/{idNotificacion}")
    public Notificacion deltetNotificacion(@PathVariable String idNotificacion){
        Notificacion notificacion=this.notificacionRepository.findByRegexNotificacion(idNotificacion);
        if(notificacion==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se encontra la notificaion con id: "+idNotificacion);
        }
        this.notificacionRepository.deleteById(idNotificacion);
        return notificacion;
    }

    @PutMapping("updateNotification/{idNotificacion}")
    public Notificacion putNotificacion(@PathVariable String idNotificacion, @RequestBody Notificacion notificacion){
        Optional<Notificacion> notificacionData = notificacionRepository.findById(idNotificacion);
        if(!notificacionData.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se encontra la notificaion con id: "+idNotificacion);
        }else{
            if(!notificacionData.isEmpty()){
                Notificacion _notificacion=notificacionData.get();
                _notificacion.setPlanes(notificacion.getPlanes());
                _notificacion.setMusicaNueva(notificacion.getMusicaNueva());
                _notificacion.setPlaylist(notificacion.getPlaylist());
                notificacionRepository.save(_notificacion);  

                return _notificacion;
            }else{
                throw new ResponseStatusException(HttpStatus.NOT_FOUND,"xxxxxx"+idNotificacion);

            }
        }     

    }
    
}
