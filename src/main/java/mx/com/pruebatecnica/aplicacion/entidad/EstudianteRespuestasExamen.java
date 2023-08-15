package mx.com.pruebatecnica.aplicacion.entidad;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.com.pruebatecnica.aplicacion.entidad.composicion.EstudianteRespuestasExamenId;

@Entity
@Table(schema = "public", name = "estudiante_respuestas_examen")
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(EstudianteRespuestasExamenId.class)
public class EstudianteRespuestasExamen {

	@Id
	@Column(name = "id_estudiante")
	private UUID idEstudiante;

	@Id
	@Column(name = "id_examen")
	private UUID idExamen;

	@Id
	@Column(name = "id_pregunta")
	private UUID idPregunta;

	@Column(name = "respuesta", nullable = false, length = 1)
	private String respuesta;
}
