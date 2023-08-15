package mx.com.pruebatecnica.aplicacion.repositorio;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.Repository;

import mx.com.pruebatecnica.aplicacion.entidad.Examen;

public interface ExamenRepositorio extends Repository<Examen, UUID> {

	Examen save(Examen examen);

	Optional<Examen> findById(UUID id);

}
