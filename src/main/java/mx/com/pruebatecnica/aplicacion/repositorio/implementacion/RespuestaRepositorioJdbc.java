package mx.com.pruebatecnica.aplicacion.repositorio.implementacion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.UUID;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import mx.com.pruebatecnica.aplicacion.entidad.Respuesta;
import mx.com.pruebatecnica.aplicacion.repositorio.RespuestaRepositorio;

@Slf4j
@Repository
@RequiredArgsConstructor
public class RespuestaRepositorioJdbc implements RespuestaRepositorio {

	private final JdbcTemplate jdbcTemplate;

	private static final String OBTENER_RESPUESTAS_EXAMEN_ESTUDIANTE = "select pregunta.opcion_correcta, respuesta_examen.respuesta "
			+ "from pregunta pregunta inner join estudiante_respuestas_examen respuesta_examen "
			+ "on pregunta.id = respuesta_examen.id_pregunta and pregunta.id_examen = respuesta_examen.id_examen "
			+ "where respuesta_examen.id_estudiante = ? and respuesta_examen.id_examen = ?";

	@Override
	public List<Respuesta> buscarRespuestasEstudiante(UUID idEstudiante, UUID idExamen) {
		return this.jdbcTemplate.query(OBTENER_RESPUESTAS_EXAMEN_ESTUDIANTE, new Object[] { idEstudiante, idExamen },
				new int[] { Types.OTHER, Types.OTHER }, this::mapearResultado);
	}

	@SneakyThrows
	private Respuesta mapearResultado(ResultSet resultSet, int rowNumber) {
		try {
			return new Respuesta(resultSet.getString("opcion_correcta"), resultSet.getString("respuesta"));
		} catch (SQLException excepcion) {
			log.error("Ocurrio un error al intentar mapear las respuestas "
					+ "del estudiante y obtener las respuesta a la pregunta, causa: :{}", excepcion);
			throw excepcion;
		}
	}

}
