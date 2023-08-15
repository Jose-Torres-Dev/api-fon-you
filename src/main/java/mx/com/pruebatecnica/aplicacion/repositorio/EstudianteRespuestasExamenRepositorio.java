package mx.com.pruebatecnica.aplicacion.repositorio;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.Repository;

import mx.com.pruebatecnica.aplicacion.entidad.EstudianteRespuestasExamen;
import mx.com.pruebatecnica.aplicacion.entidad.composicion.EstudianteRespuestasExamenId;

public interface EstudianteRespuestasExamenRepositorio
		extends Repository<EstudianteRespuestasExamen, EstudianteRespuestasExamenId> {

	Iterable<EstudianteRespuestasExamen> saveAll(Iterable<EstudianteRespuestasExamen> respuestas);

	List<EstudianteRespuestasExamen> findByIdEstudianteAndIdExamen(UUID idEstudiante, UUID idExamen);
}
