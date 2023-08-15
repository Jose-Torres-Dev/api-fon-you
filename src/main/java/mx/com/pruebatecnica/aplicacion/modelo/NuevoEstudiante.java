package mx.com.pruebatecnica.aplicacion.modelo;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.com.pruebatecnica.aplicacion.validador.IdentificadorZona;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NuevoEstudiante {

	@NotNull(message = "Se require un nombre para el estudiante.")
	@Size(message = "El nombre debe tener como minimo {min} caracteres y como maximo {max}", min = 3, max = 300)
	private String nombre;

	@Min(message = "La edad minima debe ser {value}", value = 4)
	@Max(message = "La edad maxima debe ser {value}", value = 100)
	private Integer edad;

	@NotNull(message = "Se require la ciudad")
	@Size(message = "La ciudad debe tener como minimo {min} caracteres y como maximo {max}", min = 1, max = 300)
	private String ciudad;

	@IdentificadorZona
	private String zonaHoraria;
}
