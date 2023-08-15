package mx.com.pruebatecnica.aplicacion.servicio.implementacion;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mx.com.pruebatecnica.aplicacion.excepcion.NoRegistradoExcepcion;
import mx.com.pruebatecnica.aplicacion.mapeador.EstudianteRespuestasExamenMapeador;
import mx.com.pruebatecnica.aplicacion.modelo.NuevoEstudianteRespuestasExamen;
import mx.com.pruebatecnica.aplicacion.repositorio.EstudianteRespuestasExamenRepositorio;
import mx.com.pruebatecnica.aplicacion.servicio.EstudianteRespuestasExamenServicio;

@Slf4j
@Service
@RequiredArgsConstructor
public class EstudianteRespuestasExamenServicioImpl implements EstudianteRespuestasExamenServicio {

	private final EstudianteRespuestasExamenRepositorio estudianteRespuestasExamenRepositorio;

	// @formatter:off
	@Transactional
	@Override
	public void guardarRespuestas(List<NuevoEstudianteRespuestasExamen> respuestas) {
		var registroRespuestas = respuestas.stream()
			.map(EstudianteRespuestasExamenMapeador
					::transformarAEntidad)
			.toList();
		try {
			this.estudianteRespuestasExamenRepositorio.saveAll(registroRespuestas);
		} catch (DataAccessException excepcion) {
			log.error("Ocurrio un error al registrar las respuesta del examen de un estudiante, causa: {}", excepcion);
			throw new NoRegistradoExcepcion();
		}
	}
	// @formatter:on

}
