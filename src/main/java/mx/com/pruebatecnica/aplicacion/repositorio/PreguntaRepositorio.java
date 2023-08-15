package mx.com.pruebatecnica.aplicacion.repositorio;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.Repository;

import mx.com.pruebatecnica.aplicacion.entidad.Pregunta;

public interface PreguntaRepositorio extends Repository<Pregunta, UUID> {

	Iterable<Pregunta> saveAll(Iterable<Pregunta> preguntas);

	List<Pregunta> findByIdExamen(UUID idExamen);
	
	long countByIdExamen(UUID idExamen);

}
