package mx.com.pruebatecnica.aplicacion.repositorio;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.Repository;

import mx.com.pruebatecnica.aplicacion.entidad.Estudiante;

public interface EstudianteRepositorio extends Repository<Estudiante, UUID> {

	Estudiante save(Estudiante estudiante);

	Optional<Estudiante> findById(UUID id);

}
