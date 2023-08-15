package mx.com.pruebatecnica.aplicacion.controlador;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import mx.com.pruebatecnica.aplicacion.modelo.AsignacionExamen;
import mx.com.pruebatecnica.aplicacion.modelo.CalificacionFinal;
import mx.com.pruebatecnica.aplicacion.modelo.ExamenRegistrado;
import mx.com.pruebatecnica.aplicacion.modelo.NuevaAsignacionExamen;
import mx.com.pruebatecnica.aplicacion.modelo.NuevoEstudianteRespuestasExamen;
import mx.com.pruebatecnica.aplicacion.modelo.NuevoExamen;
import mx.com.pruebatecnica.aplicacion.servicio.CalificacionServicio;
import mx.com.pruebatecnica.aplicacion.servicio.EstudianteAsignacionExamenServicio;
import mx.com.pruebatecnica.aplicacion.servicio.EstudianteRespuestasExamenServicio;
import mx.com.pruebatecnica.aplicacion.servicio.ExamenServicio;

@Validated
@RestController
@RequestMapping(path = "/examenes")
@RequiredArgsConstructor
public class ExamenControlador {

	private final ExamenServicio examenServicio;

	private final EstudianteAsignacionExamenServicio estudianteAsignacionExamenServicio;

	private final EstudianteRespuestasExamenServicio estudianteRespuestasExamenServicio;

	private final CalificacionServicio calificacionServicio;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ExamenRegistrado> crearNuevoExamen(@Validated @RequestBody NuevoExamen examen) {
		var examenCreado = this.examenServicio.crearExamen(examen);
		return ResponseEntity.status(HttpStatus.CREATED).body(examenCreado);
	}

	@PostMapping(path = "/asignaciones", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AsignacionExamen> asignarExamen(@Validated @RequestBody NuevaAsignacionExamen asignacion) {
		var asignacionExamen = this.estudianteAsignacionExamenServicio.asignarExamen(asignacion);
		return ResponseEntity.status(HttpStatus.CREATED).body(asignacionExamen);
	}

	@PostMapping(path = "/calificaciones-examen", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AsignacionExamen> capturarCalificaciones(
			@Validated @RequestBody List<NuevoEstudianteRespuestasExamen> respuestas) {
		this.estudianteRespuestasExamenServicio.guardarRespuestas(respuestas);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@GetMapping(path = "/calificaciones-examen-{idExamen}/estudiante-{idEstudiante}")
	public ResponseEntity<CalificacionFinal> calificarExamen(
			@PathVariable("idEstudiante") UUID idEstudiante,
			@PathVariable("idExamen") UUID idExamen) {
		return ResponseEntity.ok(this.calificacionServicio.obtenerCalificacionExamen(idEstudiante, idExamen));
	}

}
