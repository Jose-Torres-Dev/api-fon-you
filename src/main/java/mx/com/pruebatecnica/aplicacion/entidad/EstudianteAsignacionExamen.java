package mx.com.pruebatecnica.aplicacion.entidad;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.com.pruebatecnica.aplicacion.entidad.composicion.EstudianteAsignacionExamenId;

@Entity
@Table(schema = "public", name = "estudiante_asignacion_examen")
@Data
@NoArgsConstructor
@IdClass(EstudianteAsignacionExamenId.class)
public class EstudianteAsignacionExamen {

	@Id
	@Column(name = "id_examen")
	private UUID idExamen;

	@Id
	@Column(name = "id_estudiante")
	private UUID idEstudiante;

	@Column(name = "fecha_presentacion", nullable = false)
	private LocalDateTime fechaPresentacion;

	@Column(name = "zona_horaria", nullable = false, length = 120)
	private String zonaHoraria;

}
