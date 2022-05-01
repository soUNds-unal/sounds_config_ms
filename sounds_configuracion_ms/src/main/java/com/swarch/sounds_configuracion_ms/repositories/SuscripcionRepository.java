package com.swarch.sounds_configuracion_ms.repositories;

import java.util.List;

import com.swarch.sounds_configuracion_ms.models.Suscripcion;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SuscripcionRepository extends MongoRepository<Suscripcion,String>{
    @Query("{'idSuscripcion':{'$regex':?0,'$options':'i'}}")
    List<Suscripcion> findByRegexIdSuscripcion(String idSuscripcion);

    @Query("{'idSuscripcion':{'$regex':?0,'$options':'i'}}")
    Suscripcion findByRegexSuscripcion(String idSuscripcion);
    
}
