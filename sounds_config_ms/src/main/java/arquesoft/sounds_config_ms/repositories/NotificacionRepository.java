package arquesoft.sounds_config_ms.repositories;




import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import arquesoft.sounds_config_ms.models.Notificacion;

@Repository
public interface NotificacionRepository extends MongoRepository<Notificacion,String>{
    @Query("{'idNotificacion':{'$regex':?0,'$options':'i'}}")
    Notificacion findByRegexNotificacion(String idNotificacion);

	
    
}
