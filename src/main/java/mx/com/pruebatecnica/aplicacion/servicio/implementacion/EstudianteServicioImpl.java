package mx.com.pruebatecnica.aplicacion.servicio.implementacion;

import java.util.UUID;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mx.com.pruebatecnica.aplicacion.entidad.Estudiante;
import mx.com.pruebatecnica.aplicacion.excepcion.NoEncontradoExcepcion;
import mx.com.pruebatecnica.aplicacion.excepcion.NoRegistradoExcepcion;
import mx.com.pruebatecnica.aplicacion.mapeador.EstudianteMapeador;
import mx.com.pruebatecnica.aplicacion.modelo.EstudianteRegistrado;
import mx.com.pruebatecnica.aplicacion.modelo.NuevoEstudiante;
import mx.com.pruebatecnica.aplicacion.repositorio.EstudianteRepositorio;
import mx.com.pruebatecnica.aplicacion.servicio.EstudianteServicio;

@Slf4j
@Service
@RequiredArgsConstructor
public class EstudianteServicioImpl implements EstudianteServicio {

	private final EstudianteRepositorio estudianteRepositorio;

	@Transactional
	@Override
	public EstudianteRegistrado registrarEstudiante(NuevoEstudiante estudiante) {
		var entidad = EstudianteMapeador.transformarAEntidad(estudiante);
		try {
			entidad = this.estudianteRepositorio.save(entidad);
			return new EstudianteRegistrado(entidad.getId());
		} catch (DataAccessException excepcion) {
			log.error("Ocurrio un error al registrar un estudiante, causa: {}", excepcion);
			throw new NoRegistradoExcepcion();
		}
	}

	@Transactional(readOnly = true)
	@Override
	public Estudiante findById(UUID id) {
		try {
			return this.estudianteRepositorio.findById(id)
				.orElseThrow(NoEncontradoExcepcion::new);
		} catch (DataAccessException excepcion) {
			log.error("Ocurrio un error al buscar un estudiante con id: {}, causa: {}", id, excepcion);
			throw new NoRegistradoExcepcion();
		}
	}

}
