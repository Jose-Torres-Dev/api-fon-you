package mx.com.pruebatecnica.aplicacion.servicio;

import java.util.List;
import java.util.UUID;

import mx.com.pruebatecnica.aplicacion.entidad.Respuesta;

public interface RespuestaServicio {

	List<Respuesta> buscarRespuestas(UUID idEstudiante, UUID idExamen);
}
