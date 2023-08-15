package mx.com.pruebatecnica.aplicacion.servicio;

import java.util.UUID;

import mx.com.pruebatecnica.aplicacion.entidad.Estudiante;
import mx.com.pruebatecnica.aplicacion.modelo.EstudianteRegistrado;
import mx.com.pruebatecnica.aplicacion.modelo.NuevoEstudiante;

public interface EstudianteServicio {

	EstudianteRegistrado registrarEstudiante(NuevoEstudiante estudiante);

	Estudiante findById(UUID id);
}
