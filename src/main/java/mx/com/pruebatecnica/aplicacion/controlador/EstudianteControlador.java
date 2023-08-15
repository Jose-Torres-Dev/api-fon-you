package mx.com.pruebatecnica.aplicacion.controlador;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import mx.com.pruebatecnica.aplicacion.modelo.EstudianteRegistrado;
import mx.com.pruebatecnica.aplicacion.modelo.NuevoEstudiante;
import mx.com.pruebatecnica.aplicacion.servicio.EstudianteServicio;

@Validated
@RestController
@RequestMapping(path = "/estudiantes")
@RequiredArgsConstructor
public class EstudianteControlador {

	private final EstudianteServicio estudianteServicio;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EstudianteRegistrado> registrarEstudiante(
			@Validated @RequestBody NuevoEstudiante estudiante) {
		var estudianteCreado = this.estudianteServicio.registrarEstudiante(estudiante);
		return ResponseEntity.status(HttpStatus.CREATED).body(estudianteCreado);
	}
}
