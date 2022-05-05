package arquesoft.sounds_config_ms.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import arquesoft.sounds_config_ms.models.Suscripcion;

@Repository
public interface SuscripcionRepository extends MongoRepository<Suscripcion,String>{
    @Query("{'idSuscripcion':{'$regex':?0,'$options':'i'}}")
    List<Suscripcion> findByRegexIdSuscripcion(String idSuscripcion);

    @Query("{'idSuscripcion':{'$regex':?0,'$options':'i'}}")
    Suscripcion findByRegexSuscripcion(String idSuscripcion);
    
}
