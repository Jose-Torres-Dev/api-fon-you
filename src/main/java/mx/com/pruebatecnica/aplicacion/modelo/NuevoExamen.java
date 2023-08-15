package mx.com.pruebatecnica.aplicacion.modelo;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NuevoExamen {

	@NotNull(message = "Se require un nombre para el examen.")
	@Size(message = "El nombre del examen debe tener como minimo {min} caracteres y como maximo {max}", min = 3, max = 150)
	private String nombre;

	@NotNull(message = "Se requiere de al menos 1 pregunta para asignar al examen.")
	@Size(message = "El numero de preguntas debe ser como minimo {min} y como maximo {max}", min = 1, max = 100)
	private List<@Valid PreguntaExamen> preguntas;

}
