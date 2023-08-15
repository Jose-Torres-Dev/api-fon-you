package mx.com.pruebatecnica.aplicacion.servicio.implementacion;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mx.com.pruebatecnica.aplicacion.entidad.Pregunta;
import mx.com.pruebatecnica.aplicacion.excepcion.NoRegistradoExcepcion;
import mx.com.pruebatecnica.aplicacion.mapeador.PreguntaMapeador;
import mx.com.pruebatecnica.aplicacion.modelo.PreguntaExamen;
import mx.com.pruebatecnica.aplicacion.modelo.PreguntaRegistrada;
import mx.com.pruebatecnica.aplicacion.repositorio.PreguntaRepositorio;
import mx.com.pruebatecnica.aplicacion.servicio.PreguntaServicio;

@Slf4j
@Service
@RequiredArgsConstructor
public class PreguntaServicioImpl implements PreguntaServicio {

	private final PreguntaRepositorio preguntaRepositorio;

	@Transactional
	@Override
	public List<PreguntaRegistrada> guardarPreguntas(List<PreguntaExamen> preguntas) {
		var nuevasPreguntas = preguntas.stream().map(PreguntaMapeador::transformarAEntidad).toList();
		try {
			var preguntasRegistradas = this.preguntaRepositorio.saveAll(nuevasPreguntas);

			List<Pregunta> listaPreguntas = new ArrayList<>();
			preguntasRegistradas.iterator().forEachRemaining(listaPreguntas::add);
			return listaPreguntas.stream().map(Pregunta::getId).map(PreguntaRegistrada::new).toList();
		} catch (DataAccessException excepcion) {
			log.error("Ocurrio un error al momento de guardar las preguntas del examen, causa: {}", excepcion);
			throw new NoRegistradoExcepcion();
		}
	}

	@Transactional(readOnly = true)
	@Override
	public long contarPreguntasExamen(UUID idExamen) {
		return this.preguntaRepositorio.countByIdExamen(idExamen);
	}

}
