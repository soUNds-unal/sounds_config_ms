package arquesoft.sounds_config_ms.models;

/*import java.util.ArrayList;*/

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Configuracion {
    @Id
    private String idConfig;
    private String idUsuario;
    private boolean privacidad;
    @Field("idSuscripcion")
	@DBRef
    Suscripcion suscripcion;  
        //tipo 0 gratis (publicidad)
        //tipo 1 premium (sin publicidad)
	@Field("idNotificacion")
	@DBRef
    Notificacion notificacion;

    

    public Configuracion(String idUsuario, boolean privacidad,Suscripcion suscripcion, Notificacion notificacion ){
        this.idUsuario=idUsuario;
        this.privacidad=privacidad;
        this.notificacion=notificacion;
        this.suscripcion=suscripcion;

    }
    public void setId(String idConfig){
        this.idConfig=idConfig;

    }
    public String getId(){
        return idConfig;
    }


    public void setIdUsuario(String idUsuario){
        this.idUsuario=idUsuario;
    }
    public String getIdUsuario(){
        return idUsuario;
    }

    public boolean getPrivacidad(){
        return privacidad;
    }
    public void setPrivacidad(boolean privacidad){
        this.privacidad=privacidad;
    }

    public Notificacion getNotificacion(){
        return notificacion;
    }
    public void setNotificacion(Notificacion notificacion){
        this.notificacion=notificacion;
    }

    public Suscripcion getSuscripcion(){
        return suscripcion;
    }
    public void setSuscripcion(Suscripcion suscripcion){
        this.suscripcion=suscripcion;
    }

}



