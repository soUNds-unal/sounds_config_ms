package com.swarch.sounds_configuracion_ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SoundsConfiguracionMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoundsConfiguracionMsApplication.class, args);
	}

}/*
//CMD gunicorn --bind 0.0.0.0:$PORT wsgi
ARG JAR_FILE=target/*.jar 

COPY ${JAR_FILE} app.jar 

ENTRYPOINT [ "java","jar","/app.jar" ]*/