package mx.com.pruebatecnica.aplicacion.servicio.implementacion;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mx.com.pruebatecnica.aplicacion.excepcion.NoRegistradoExcepcion;
import mx.com.pruebatecnica.aplicacion.mapeador.ExamenMapeador;
import mx.com.pruebatecnica.aplicacion.modelo.ExamenRegistrado;
import mx.com.pruebatecnica.aplicacion.modelo.NuevoExamen;
import mx.com.pruebatecnica.aplicacion.repositorio.ExamenRepositorio;
import mx.com.pruebatecnica.aplicacion.servicio.ExamenServicio;
import mx.com.pruebatecnica.aplicacion.servicio.PreguntaServicio;

@Slf4j
@Service
@RequiredArgsConstructor
public class ExamenServicioImpl implements ExamenServicio {

	private final ExamenRepositorio examenRepositorio;

	private final PreguntaServicio preguntaServicio;

	// @formatter:off
	@Transactional
	@Override
	public ExamenRegistrado crearExamen(NuevoExamen nuevoExamen) {
		var examen = ExamenMapeador.transformarAEntidad(nuevoExamen);
		try {
			log.info("Entidad examen: {}", examen);
			var entidad = this.examenRepositorio.save(examen);
			var preguntas = nuevoExamen.getPreguntas().stream()
				.map((var preguntaExamen) -> {
					preguntaExamen.setIdExamen(entidad.getId());
					return preguntaExamen;
				}).toList();
			var preguntasRegistradas = this.preguntaServicio.guardarPreguntas(preguntas);
			return new ExamenRegistrado(entidad.getId(), preguntasRegistradas);
		} catch (DataAccessException excepcion) {
			log.error("Ocurrio un error al crear un nuevo examen, causa: {}", excepcion);
			throw new NoRegistradoExcepcion();
		}
	}
	// @formatter:on

}
