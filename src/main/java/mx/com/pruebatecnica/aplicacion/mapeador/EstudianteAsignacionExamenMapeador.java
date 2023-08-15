package mx.com.pruebatecnica.aplicacion.mapeador;

import lombok.experimental.UtilityClass;
import mx.com.pruebatecnica.aplicacion.entidad.EstudianteAsignacionExamen;
import mx.com.pruebatecnica.aplicacion.modelo.NuevaAsignacionExamen;

@UtilityClass
public class EstudianteAsignacionExamenMapeador {

	public static EstudianteAsignacionExamen transformarAEntidad(NuevaAsignacionExamen asignacionExamen) {
		var estudianteAsignacionExamen = new EstudianteAsignacionExamen();
		estudianteAsignacionExamen.setFechaPresentacion(asignacionExamen.getFechaPresentacion());
		estudianteAsignacionExamen.setIdEstudiante(asignacionExamen.getIdEstudiante());
		estudianteAsignacionExamen.setIdExamen(asignacionExamen.getIdExamen());
		estudianteAsignacionExamen.setZonaHoraria(asignacionExamen.getZonaHoraria());
		return estudianteAsignacionExamen;
	}
}
