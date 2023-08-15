package mx.com.pruebatecnica.aplicacion.servicio.implementacion;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import mx.com.pruebatecnica.aplicacion.modelo.CalificacionFinal;
import mx.com.pruebatecnica.aplicacion.servicio.CalificacionServicio;
import mx.com.pruebatecnica.aplicacion.servicio.PreguntaServicio;
import mx.com.pruebatecnica.aplicacion.servicio.RespuestaServicio;

@Service
@RequiredArgsConstructor
public class CalificacionServicioImpl implements CalificacionServicio {

	@Value("${examen.puntuacion-total}")
	private double puntuacionTotal;

	private final PreguntaServicio preguntaServicio;

	private final RespuestaServicio respuestaServicio;

	@Transactional(readOnly = true)
	@Override
	public CalificacionFinal obtenerCalificacionExamen(UUID idEstudiante, UUID idExamen) {
		var totalPreguntas = this.preguntaServicio.contarPreguntasExamen(idExamen);
		var respuestas = this.respuestaServicio.buscarRespuestas(idEstudiante, idExamen);

		var puntos = new BigDecimal(String.valueOf(this.puntuacionTotal));
		var puntosPorPregunta = puntos.divide(new BigDecimal(totalPreguntas), RoundingMode.DOWN);
		var puntuacion = new BigDecimal("00.00");

		for (var respuesta : respuestas) {
			if (respuesta.getOpcionCorrecta().equalsIgnoreCase(respuesta.getRespuesta())) {
				puntuacion = puntuacion.add(puntosPorPregunta);
			}
		}
		return new CalificacionFinal(puntuacion);
	}

}
