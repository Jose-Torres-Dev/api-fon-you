package mx.com.pruebatecnica.aplicacion.repositorio.implementacion;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assumptions.assumingThat;
import static org.mockito.ArgumentMatchers.any;
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
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.util.CollectionUtils;

import mx.com.pruebatecnica.aplicacion.utilerias.DatosPrueba;

@ExtendWith(MockitoExtension.class)
public class RespuestaRepositorioJdbcTest {

	@Mock
	private JdbcTemplate jdbcTemplate;

	@InjectMocks
	private RespuestaRepositorioJdbc respositorio;

	private static final String CONSULTA = "select pregunta.opcion_correcta, respuesta_examen.respuesta "
			+ "from pregunta pregunta inner join estudiante_respuestas_examen respuesta_examen "
			+ "on pregunta.id = respuesta_examen.id_pregunta and pregunta.id_examen = respuesta_examen.id_examen "
			+ "where respuesta_examen.id_estudiante = ? and respuesta_examen.id_examen = ?";

	@Test
	@SuppressWarnings("unchecked")
	void probar_buscar_respuestas_estudiante_exitosamente() {

		when(this.jdbcTemplate.query(eq(CONSULTA), any(Object[].class), 
				any(int[].class), any(RowMapper.class)))
				.thenReturn(DatosPrueba.respuestasPruebas());

		var respuestas = this.respositorio.buscarRespuestasEstudiante(
				UUID.fromString("d208aa2f-a3db-4766-8091-77ee33716bb6"),
				UUID.fromString("07592133-333d-4d38-8e93-7a20c2df1603"));

		verify(this.jdbcTemplate).query(eq(CONSULTA), any(Object[].class), 
				any(int[].class), any(RowMapper.class));

		assertNotNull(respuestas);
		assumingThat(() -> {
			return !CollectionUtils.isEmpty(respuestas);
		}, () -> {
			var primeraRespuesta = CollectionUtils.firstElement(respuestas);

			assertEquals("A", primeraRespuesta.getOpcionCorrecta());
			assertEquals("B", primeraRespuesta.getRespuesta());

			var segundaRespuesta = respuestas.get(1);

			assertEquals("C", segundaRespuesta.getOpcionCorrecta());
			assertEquals("D", segundaRespuesta.getRespuesta());

			var terceraRespuesta = respuestas.get(2);

			assertEquals("D", terceraRespuesta.getOpcionCorrecta());
			assertEquals("C", terceraRespuesta.getRespuesta());

			var cuartaRespuesta = respuestas.get(3);

			assertEquals("B", cuartaRespuesta.getOpcionCorrecta());
			assertEquals("B", cuartaRespuesta.getRespuesta());
		});
	}

	@Test
	@SuppressWarnings("unchecked")
	void probar_buscar_respuestas_estudiante_excepcion() {
		
		when(this.jdbcTemplate.query(eq(CONSULTA), any(Object[].class), 
			 any(int[].class), any(RowMapper.class)))
			.thenThrow(new DataAccessResourceFailureException("Recurso no encontrado", new SQLException()));

		assertThatThrownBy(()->{
			this.respositorio.buscarRespuestasEstudiante(
					UUID.fromString("d208aa2f-a3db-4766-8091-77ee33716bb6"),
					UUID.fromString("07592133-333d-4d38-8e93-7a20c2df1603"));
		}).isExactlyInstanceOf(DataAccessResourceFailureException.class);
	}

}
