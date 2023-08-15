package mx.com.pruebatecnica.aplicacion.servicio.implementacion;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import mx.com.pruebatecnica.aplicacion.entidad.Respuesta;
import mx.com.pruebatecnica.aplicacion.excepcion.NoEncontradoExcepcion;
import mx.com.pruebatecnica.aplicacion.repositorio.RespuestaRepositorio;
import mx.com.pruebatecnica.aplicacion.servicio.RespuestaServicio;

@Service
@RequiredArgsConstructor
public class RespuestaServicioImpl implements RespuestaServicio {

	private final RespuestaRepositorio respuestaRepositorio;

	@Transactional(readOnly = true)
	@Override
	public List<Respuesta> buscarRespuestas(UUID idEstudiante, UUID idExamen) {
		try {
			return this.respuestaRepositorio.buscarRespuestasEstudiante(idEstudiante, idExamen);
		} catch (Exception excepcion) {
			throw new NoEncontradoExcepcion();
		}
	}

}
