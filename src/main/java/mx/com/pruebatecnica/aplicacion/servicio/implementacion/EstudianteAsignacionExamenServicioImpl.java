package mx.com.pruebatecnica.aplicacion.servicio.implementacion;

import java.time.ZoneId;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mx.com.pruebatecnica.aplicacion.excepcion.NoRegistradoExcepcion;
import mx.com.pruebatecnica.aplicacion.mapeador.EstudianteAsignacionExamenMapeador;
import mx.com.pruebatecnica.aplicacion.modelo.AsignacionExamen;
import mx.com.pruebatecnica.aplicacion.modelo.NuevaAsignacionExamen;
import mx.com.pruebatecnica.aplicacion.repositorio.EstudianteAsignacionExamenRepositorio;
import mx.com.pruebatecnica.aplicacion.servicio.EstudianteAsignacionExamenServicio;
import mx.com.pruebatecnica.aplicacion.servicio.EstudianteServicio;

@Slf4j
@Service
@RequiredArgsConstructor
public class EstudianteAsignacionExamenServicioImpl implements EstudianteAsignacionExamenServicio {

	private final EstudianteAsignacionExamenRepositorio asignacionExamenRepositorio;

	private final EstudianteServicio estudianteServicio;

	@Transactional
	@Override
	public AsignacionExamen asignarExamen(NuevaAsignacionExamen asignacion) {
		var entidad = EstudianteAsignacionExamenMapeador.transformarAEntidad(asignacion);
		try {
			entidad = this.asignacionExamenRepositorio.save(entidad);
			var estudiante = this.estudianteServicio.findById(asignacion.getIdEstudiante());

			var horarioLocalFechaPresentacion = entidad.getFechaPresentacion();
			var zonaLocalFechaPresentacion = ZoneId.of(entidad.getZonaHoraria());

			var zonaDestino = ZoneId.of(estudiante.getZonaHoraria());
			var horarioDestino = horarioLocalFechaPresentacion.atZone(zonaLocalFechaPresentacion)
					.withZoneSameInstant(zonaDestino);
			return new AsignacionExamen("La fecha de presentacion del examen para la zona ".concat(zonaDestino.toString())
					.concat(" es: " + horarioDestino.toString()));

		} catch (DataAccessException excepcion) {
			log.error("Ocurrio un error al registrar la asignacion del examen a un estudiante, causa: {}", excepcion);
			throw new NoRegistradoExcepcion();
		}
	}

}
