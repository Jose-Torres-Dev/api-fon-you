package mx.com.pruebatecnica.aplicacion.servicio;

import java.util.List;

import mx.com.pruebatecnica.aplicacion.modelo.NuevoEstudianteRespuestasExamen;

public interface EstudianteRespuestasExamenServicio {

	void guardarRespuestas(List<NuevoEstudianteRespuestasExamen> respuestas);

}
