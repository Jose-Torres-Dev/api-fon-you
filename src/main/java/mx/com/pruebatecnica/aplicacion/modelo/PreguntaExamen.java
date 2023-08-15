package mx.com.pruebatecnica.aplicacion.modelo;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PreguntaExamen {

	private UUID idExamen;

	@NotBlank(message = "La interrogante no puede ser nula o vacia.")
	@Size(message = "La interrogante debe tener como minimo {min} caracteres y como maximo {max}", min = 1, max = 300)
	private String interrogante;

	@NotBlank(message = "La primera opcion no puede ser nula o vacia.")
	@Size(message = "La primera opcion debe tener como minimo {min} caracteres y como maximo {max}", min = 1, max = 100)
	private String primeraOpcion;

	@NotBlank(message = "La segunda opcion no puede ser nula o vacia.")
	@Size(message = "La segunda opcion debe tener como minimo {min} caracteres y como maximo {max}", min = 1, max = 100)
	private String segundaOpcion;

	@NotBlank(message = "La tercera opcion no puede ser nula o vacia.")
	@Size(message = "La tercera opcion debe tener como minimo {min} caracteres y como maximo {max}", min = 1, max = 100)
	private String terceraOpcion;

	@NotBlank(message = "La cuarta opcion no puede ser nula o vacia.")
	@Size(message = "La cuarta opcion debe tener como minimo {min} caracteres y como maximo {max}", min = 1, max = 100)
	private String cuartaOpcion;

	@NotBlank(message = "La opcion correcta no puede ser nula o vacia.")
	@NotBlank(message = "La opcion correcta no puede estar vacia")
	private String opcionCorrecta;
}
