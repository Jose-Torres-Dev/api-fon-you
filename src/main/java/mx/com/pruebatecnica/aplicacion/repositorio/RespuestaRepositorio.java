package mx.com.pruebatecnica.aplicacion.repositorio;

import java.util.List;
import java.util.UUID;

import mx.com.pruebatecnica.aplicacion.entidad.Respuesta;

public interface RespuestaRepositorio {

	List<Respuesta> buscarRespuestasEstudiante(UUID idEstudiante, UUID idExamen);
}
