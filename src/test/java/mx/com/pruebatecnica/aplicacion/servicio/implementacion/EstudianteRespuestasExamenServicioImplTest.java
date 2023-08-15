package mx.com.pruebatecnica.aplicacion.servicio.implementacion;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataAccessResourceFailureException;

import mx.com.pruebatecnica.aplicacion.excepcion.NoRegistradoExcepcion;
import mx.com.pruebatecnica.aplicacion.modelo.NuevoEstudianteRespuestasExamen;
import mx.com.pruebatecnica.aplicacion.repositorio.EstudianteRespuestasExamenRepositorio;
import mx.com.pruebatecnica.aplicacion.utilerias.DatosPrueba;

@ExtendWith(MockitoExtension.class)
public class EstudianteRespuestasExamenServicioImplTest {

	@Mock
	private EstudianteRespuestasExamenRepositorio estudianteRespuestasExamenRepositorio;

	@InjectMocks
	private EstudianteRespuestasExamenServicioImpl estudianteRespuestasExamenServicio;

	@Test
	void test_guardar_respuestas_exitosamente() {
		List<NuevoEstudianteRespuestasExamen> respuestas = DatosPrueba.crearNuevoEstudianteRespuestasExamen();
		var entidades = DatosPrueba.crearEstudianteRespuestasExamen();

		when(this.estudianteRespuestasExamenRepositorio.saveAll(eq(entidades))).thenReturn(entidades);

		this.estudianteRespuestasExamenServicio.guardarRespuestas(respuestas);

		verify(this.estudianteRespuestasExamenRepositorio).saveAll(eq(entidades));
	}

	@Test
	void test_guardar_respuestas_exepcion() {
		List<NuevoEstudianteRespuestasExamen> respuestas = DatosPrueba.crearNuevoEstudianteRespuestasExamen();
		var entidades = DatosPrueba.crearEstudianteRespuestasExamen();

		when(this.estudianteRespuestasExamenRepositorio.saveAll(eq(entidades)))
				.thenThrow(new DataAccessResourceFailureException("Recurso no encontrado", new SQLException()));

		assertThatThrownBy(() -> {
			this.estudianteRespuestasExamenServicio.guardarRespuestas(respuestas);
		}).isExactlyInstanceOf(NoRegistradoExcepcion.class);

	}

}
