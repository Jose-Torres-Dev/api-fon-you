package mx.com.pruebatecnica.aplicacion.entidad.composicion;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstudianteAsignacionExamenId {

	private UUID idExamen;

	private UUID idEstudiante;

}
