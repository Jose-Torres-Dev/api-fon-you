package mx.com.pruebatecnica.aplicacion.modelo;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.com.pruebatecnica.aplicacion.validador.IdentificadorZona;

@Data
@NoArgsConstructor
public class NuevaAsignacionExamen {

	@NotNull(message = "El identificador del examen no puede ser nulo o vacio.")
	private UUID idExamen;

	@NotNull(message = "El identificador del estudiante no puede ser nulo o vacio.")
	private UUID idEstudiante;

	@FutureOrPresent(message = "La fecha de presentacion tiene que ser hoy o una fecha futura.")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime fechaPresentacion;

	@IdentificadorZona
	private String zonaHoraria;
}
