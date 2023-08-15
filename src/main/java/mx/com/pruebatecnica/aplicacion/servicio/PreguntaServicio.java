package mx.com.pruebatecnica.aplicacion.servicio;

import java.util.List;
import java.util.UUID;

import mx.com.pruebatecnica.aplicacion.modelo.PreguntaExamen;
import mx.com.pruebatecnica.aplicacion.modelo.PreguntaRegistrada;

public interface PreguntaServicio {

	List<PreguntaRegistrada> guardarPreguntas(List<PreguntaExamen> preguntas);

	long contarPreguntasExamen(UUID idExamen);
}
