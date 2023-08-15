package mx.com.pruebatecnica.aplicacion.repositorio;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.Repository;

import mx.com.pruebatecnica.aplicacion.entidad.EstudianteAsignacionExamen;
import mx.com.pruebatecnica.aplicacion.entidad.composicion.EstudianteAsignacionExamenId;

public interface EstudianteAsignacionExamenRepositorio
		extends Repository<EstudianteAsignacionExamen, EstudianteAsignacionExamenId> {

	EstudianteAsignacionExamen save(EstudianteAsignacionExamen asignacionExamen);

	Optional<EstudianteAsignacionExamen> findById(EstudianteAsignacionExamenId id);

	List<EstudianteAsignacionExamen> findByIdEstudiante(UUID idEstudiante);

}
