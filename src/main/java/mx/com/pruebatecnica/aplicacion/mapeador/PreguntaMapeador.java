package mx.com.pruebatecnica.aplicacion.mapeador;

import lombok.experimental.UtilityClass;
import mx.com.pruebatecnica.aplicacion.entidad.Pregunta;
import mx.com.pruebatecnica.aplicacion.modelo.PreguntaExamen;

@UtilityClass
public class PreguntaMapeador {

	public static Pregunta transformarAEntidad(PreguntaExamen pregunta) {
		var entidad = new Pregunta();
		entidad.setIdExamen(pregunta.getIdExamen());
		entidad.setInterrogante(pregunta.getInterrogante());
		entidad.setPrimeraOpcion(pregunta.getPrimeraOpcion());
		entidad.setSegundaOpcion(pregunta.getSegundaOpcion());
		entidad.setTerceraOpcion(pregunta.getTerceraOpcion());
		entidad.setCuartaOpcion(pregunta.getCuartaOpcion());
		entidad.setOpcionCorrecta(pregunta.getOpcionCorrecta());
		return entidad;
	}
}
