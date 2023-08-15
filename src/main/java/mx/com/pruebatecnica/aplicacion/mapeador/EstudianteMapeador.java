package mx.com.pruebatecnica.aplicacion.mapeador;

import lombok.experimental.UtilityClass;
import mx.com.pruebatecnica.aplicacion.entidad.Estudiante;
import mx.com.pruebatecnica.aplicacion.modelo.NuevoEstudiante;

@UtilityClass
public class EstudianteMapeador {

	public static Estudiante transformarAEntidad(NuevoEstudiante nuevoEstudiante) {
		var estudiante = new Estudiante();
		estudiante.setCiudad(nuevoEstudiante.getCiudad());
		estudiante.setEdad(nuevoEstudiante.getEdad());
		estudiante.setNombre(nuevoEstudiante.getNombre());
		estudiante.setZonaHoraria(nuevoEstudiante.getZonaHoraria());
		return estudiante;
	}
}
