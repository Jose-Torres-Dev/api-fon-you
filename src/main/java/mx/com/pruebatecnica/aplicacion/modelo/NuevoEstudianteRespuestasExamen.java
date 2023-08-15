package mx.com.pruebatecnica.aplicacion.modelo;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NuevoEstudianteRespuestasExamen {

	private UUID idEstudiante;

	private UUID idExamen;

	private UUID idPregunta;

	private String respuesta;
}
