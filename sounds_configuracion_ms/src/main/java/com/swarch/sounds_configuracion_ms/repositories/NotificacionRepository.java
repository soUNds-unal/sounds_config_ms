package com.swarch.sounds_configuracion_ms.repositories;



import com.swarch.sounds_configuracion_ms.models.Notificacion;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificacionRepository extends MongoRepository<Notificacion,String>{
    @Query("{'idNotificacion':{'$regex':?0,'$options':'i'}}")
    Notificacion findByRegexNotificacion(String idNotificacion);

	
    
}
