package mx.com.pruebatecnica.aplicacion.servicio.implementacion;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import mx.com.pruebatecnica.aplicacion.servicio.PreguntaServicio;
import mx.com.pruebatecnica.aplicacion.servicio.RespuestaServicio;
import mx.com.pruebatecnica.aplicacion.utilerias.DatosPrueba;

@ExtendWith(MockitoExtension.class)
public class CalificacionServicioImplTest {

	@Mock
	private PreguntaServicio preguntaServicio;

	@Mock
	private RespuestaServicio respuestaServicio;

	@InjectMocks
	public CalificacionServicioImpl calificacionServicio;

	@BeforeEach
	void setUp() {
		ReflectionTestUtils.setField(this.calificacionServicio, "puntuacionTotal", 100.00);
	}

	@Test
	void probar_obtener_calificacion_examen_exitosamente() {

		var idEstudiante = UUID.fromString("d208aa2f-a3db-4766-8091-77ee33716bb6");
		var idExamen = UUID.fromString("07592133-333d-4d38-8e93-7a20c2df1603");
		var respuestas = DatosPrueba.respuestasPruebas();

		when(this.preguntaServicio.contarPreguntasExamen(eq(idExamen))).thenReturn((long) respuestas.size());
		when(this.respuestaServicio.buscarRespuestas(eq(idEstudiante), eq(idExamen))).thenReturn(respuestas);

		var resultado = this.calificacionServicio.obtenerCalificacionExamen(idEstudiante, idExamen);

		assertEquals("25.00", resultado.getCalificacionExamen().toString());
	}

}
