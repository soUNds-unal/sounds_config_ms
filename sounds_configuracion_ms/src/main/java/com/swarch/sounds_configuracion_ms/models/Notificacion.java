package com.swarch.sounds_configuracion_ms.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Notificacion {
    @Id
    private String idNotificacion;
    private boolean planes; // promos
    private boolean musicaNueva; // seguidores
    private boolean playlist; // actualizacion

    public String getIdNotificacion() {
        return idNotificacion;
    }

    public void setIdNotificacion(String idNotificacion) {
        this.idNotificacion = idNotificacion;
    }

    public boolean getPlanes() {
        return planes;
    }

    public void setPlanes(boolean planes) {
        this.planes = planes;
    }

    public boolean getMusicaNueva() {
        return musicaNueva;
    }

    public void setMusicaNueva(boolean musicaNueva) {
        this.musicaNueva = musicaNueva;
    }

    public boolean getPlaylist() {
        return playlist;
    }

    public void setPlaylist(boolean playlist) {
        this.playlist = playlist;
    }

}
