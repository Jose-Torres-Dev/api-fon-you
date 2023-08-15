package mx.com.pruebatecnica.aplicacion.mapeador;

import lombok.experimental.UtilityClass;
import mx.com.pruebatecnica.aplicacion.entidad.EstudianteRespuestasExamen;
import mx.com.pruebatecnica.aplicacion.modelo.NuevoEstudianteRespuestasExamen;

@UtilityClass
public class EstudianteRespuestasExamenMapeador {

	public static EstudianteRespuestasExamen transformarAEntidad(NuevoEstudianteRespuestasExamen registroRespuesta) {
		var respuesta = new EstudianteRespuestasExamen();
		respuesta.setIdEstudiante(registroRespuesta.getIdEstudiante());
		respuesta.setIdExamen(registroRespuesta.getIdExamen());
		respuesta.setIdPregunta(registroRespuesta.getIdPregunta());
		respuesta.setRespuesta(registroRespuesta.getRespuesta());
		return respuesta;
	}
	
}
