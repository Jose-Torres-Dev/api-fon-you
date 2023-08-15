package mx.com.pruebatecnica.aplicacion.utilerias;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import lombok.experimental.UtilityClass;
import mx.com.pruebatecnica.aplicacion.entidad.Estudiante;
import mx.com.pruebatecnica.aplicacion.entidad.EstudianteAsignacionExamen;
import mx.com.pruebatecnica.aplicacion.entidad.EstudianteRespuestasExamen;
import mx.com.pruebatecnica.aplicacion.entidad.Respuesta;
import mx.com.pruebatecnica.aplicacion.modelo.NuevaAsignacionExamen;
import mx.com.pruebatecnica.aplicacion.modelo.NuevoEstudianteRespuestasExamen;

@UtilityClass
public class DatosPrueba {

	public static List<Respuesta> respuestasPruebas() {
		var respuestas = new ArrayList<Respuesta>();
		respuestas.add(new Respuesta("A", "B"));
		respuestas.add(new Respuesta("C", "D"));
		respuestas.add(new Respuesta("D", "C"));
		respuestas.add(new Respuesta("B", "B"));
		return respuestas;
	}

	public static NuevaAsignacionExamen crearNuevaAsignacionExamen() {
		var idEstudiante = UUID.fromString("d208aa2f-a3db-4766-8091-77ee33716bb6");
		var idExamen = UUID.fromString("07592133-333d-4d38-8e93-7a20c2df1603");
		var asignacion = new NuevaAsignacionExamen();
		asignacion.setFechaPresentacion(LocalDateTime.of(2023, Month.APRIL, 12, 14, 22, 35));
		asignacion.setIdEstudiante(idEstudiante);
		asignacion.setIdExamen(idExamen);
		asignacion.setZonaHoraria("America/Mexico_City");
		return asignacion;
	}

	public static EstudianteAsignacionExamen crearEstudianteAsignacionExamen() {
		var nuevaAsignacion = crearNuevaAsignacionExamen();
		var asignacion = new EstudianteAsignacionExamen();
		asignacion.setFechaPresentacion(nuevaAsignacion.getFechaPresentacion());
		asignacion.setIdEstudiante(nuevaAsignacion.getIdEstudiante());
		asignacion.setIdExamen(nuevaAsignacion.getIdExamen());
		asignacion.setZonaHoraria(nuevaAsignacion.getZonaHoraria());
		return asignacion;
	}

	public static Estudiante crearEstudiante() {
		var idEstudiante = UUID.fromString("d208aa2f-a3db-4766-8091-77ee33716bb6");
		var estudiante = new Estudiante();
		estudiante.setCiudad("Panama");
		estudiante.setEdad(24);
		estudiante.setId(idEstudiante);
		estudiante.setNombre("Francisco");
		estudiante.setZonaHoraria("Asia/Barnaul");
		return estudiante;
	}

	public static List<NuevoEstudianteRespuestasExamen> crearNuevoEstudianteRespuestasExamen() {
		List<NuevoEstudianteRespuestasExamen> respuestas = new ArrayList<>();
		var idEstudiante = UUID.fromString("d208aa2f-a3db-4766-8091-77ee33716bb6");
		var idExamen = UUID.fromString("07592133-333d-4d38-8e93-7a20c2df1603");
		var idPregunta = UUID.fromString("d208aa2f-a3db-4766-8091-77ee33716bb");
		respuestas.add(new NuevoEstudianteRespuestasExamen(idEstudiante, idExamen, idPregunta, "A"));
		return respuestas;
	}

	public static Iterable<EstudianteRespuestasExamen> crearEstudianteRespuestasExamen() {
		var respuestas = new ArrayList<EstudianteRespuestasExamen>();
		var idEstudiante = UUID.fromString("d208aa2f-a3db-4766-8091-77ee33716bb6");
		var idExamen = UUID.fromString("07592133-333d-4d38-8e93-7a20c2df1603");
		var idPregunta = UUID.fromString("d208aa2f-a3db-4766-8091-77ee33716bb");
		respuestas.add(new EstudianteRespuestasExamen(idEstudiante, idExamen, idPregunta, "A"));
		return respuestas;
	}

}
