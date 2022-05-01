package com.swarch.sounds_configuracion_ms.repositories;

import com.swarch.sounds_configuracion_ms.models.Configuracion;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
//import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfiguracionRepository extends MongoRepository<Configuracion, String> {
    // @Query("{'id':{'$regex':?0,'$options':'i'}}")
    // List<Cotizacion> findByRegexIdCotizacion(String idCotizacion);
    @Query("{'idConfig':{'$regex':?0,'$options':'i'}}")
    Configuracion findByRegexConfig(String idConfig);

}
