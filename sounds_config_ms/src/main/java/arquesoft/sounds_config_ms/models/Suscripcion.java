package arquesoft.sounds_config_ms.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
 
@Document
public class Suscripcion{
    @Id
     private String idSuscripcion;
     private String nombre;
     private Integer precio;
     private String descripcion;

    public String getIdSuscripcion(){
        return idSuscripcion;
    }

    public void setIdSuscripcion(String idSuscripcion) {
        this.idSuscripcion = idSuscripcion;
    }
    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Integer getPrecio(){
        return precio;
    }
    public void setPrecio(Integer precio) {
        this.precio = precio;
    }
    public String getDescripcion(){
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


}



