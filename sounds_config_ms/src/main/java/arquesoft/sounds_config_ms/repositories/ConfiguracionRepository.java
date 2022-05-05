package arquesoft.sounds_config_ms.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
//import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import arquesoft.sounds_config_ms.models.Configuracion;

@Repository
public interface ConfiguracionRepository extends MongoRepository<Configuracion, String> {
    // @Query("{'id':{'$regex':?0,'$options':'i'}}")
    // List<Cotizacion> findByRegexIdCotizacion(String idCotizacion);
    @Query("{'idConfig':{'$regex':?0,'$options':'i'}}")
    Configuracion findByRegexConfig(String idConfig);

}
