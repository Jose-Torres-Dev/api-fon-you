package mx.com.pruebatecnica.aplicacion.servicio;

import java.util.UUID;

import mx.com.pruebatecnica.aplicacion.modelo.CalificacionFinal;

public interface CalificacionServicio {

	CalificacionFinal obtenerCalificacionExamen(UUID idEstudiante, UUID idExamen);

}
