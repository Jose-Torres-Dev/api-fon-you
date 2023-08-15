package mx.com.pruebatecnica.aplicacion.controlador;

import java.util.Arrays;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import mx.com.pruebatecnica.aplicacion.excepcion.NoEncontradoExcepcion;
import mx.com.pruebatecnica.aplicacion.excepcion.NoRegistradoExcepcion;
import mx.com.pruebatecnica.aplicacion.modelo.InformeError;

@RestControllerAdvice
public class ExcepcionControlador extends ResponseEntityExceptionHandler {

	@ExceptionHandler(NoEncontradoExcepcion.class)
	public ResponseEntity<Void> manejarNoEncontradoExcepcion(NoEncontradoExcepcion excepcion) {
		return ResponseEntity.notFound().build();
	}

	@ExceptionHandler(NoRegistradoExcepcion.class)
	public ResponseEntity<InformeError> manejarNoRegistradoExcepcion(NoRegistradoExcepcion excepcion) {
		return ResponseEntity.internalServerError().body(new InformeError(HttpStatus.INTERNAL_SERVER_ERROR,
				Arrays.asList("Ocurrio un error desconocido, consulte al administrador del sistema.")));
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException excepcion,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		var errores = excepcion.getAllErrors().stream().map(ObjectError::getDefaultMessage).toList();
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new InformeError(HttpStatus.BAD_REQUEST, errores));

	}
}
