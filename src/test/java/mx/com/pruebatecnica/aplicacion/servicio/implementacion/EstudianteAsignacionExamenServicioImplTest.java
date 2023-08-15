package mx.com.pruebatecnica.aplicacion.servicio.implementacion;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataAccessResourceFailureException;

import mx.com.pruebatecnica.aplicacion.excepcion.NoRegistradoExcepcion;
import mx.com.pruebatecnica.aplicacion.repositorio.EstudianteAsignacionExamenRepositorio;
import mx.com.pruebatecnica.aplicacion.servicio.EstudianteServicio;
import mx.com.pruebatecnica.aplicacion.utilerias.DatosPrueba;

@ExtendWith(MockitoExtension.class)
public class EstudianteAsignacionExamenServicioImplTest {

	@Mock
	private EstudianteAsignacionExamenRepositorio asignacionExamenRepositorio;

	@Mock
	private EstudianteServicio estudianteServicio;

	@InjectMocks
	private EstudianteAsignacionExamenServicioImpl estudianteAsignacionExamenServicio;

	@Test
	void test_asignar_examen_exitosamente() {
		var idEstudiante = UUID.fromString("d208aa2f-a3db-4766-8091-77ee33716bb6");
		var estudiante = DatosPrueba.crearEstudiante();
		var entidad = DatosPrueba.crearEstudianteAsignacionExamen();
		var peticion = DatosPrueba.crearNuevaAsignacionExamen();

		when(this.asignacionExamenRepositorio.save(eq(entidad))).thenReturn(entidad);
		when(this.estudianteServicio.findById(eq(idEstudiante))).thenReturn(estudiante);

		var asignacion = this.estudianteAsignacionExamenServicio.asignarExamen(peticion);

		verify(this.asignacionExamenRepositorio).save(eq(entidad));
		verify(this.estudianteServicio).findById(eq(idEstudiante));
		assertNotNull(asignacion);

	}

	@Test
	void test_asignar_examen_excepcion() {
		var entidad = DatosPrueba.crearEstudianteAsignacionExamen();
		var peticion = DatosPrueba.crearNuevaAsignacionExamen();

		when(this.asignacionExamenRepositorio.save(eq(entidad)))
				.thenThrow(new DataAccessResourceFailureException("Recurso no encontrado", new SQLException()));

		assertThatThrownBy(() -> {
			this.estudianteAsignacionExamenServicio.asignarExamen(peticion);
		}).isExactlyInstanceOf(NoRegistradoExcepcion.class);
	}

}
