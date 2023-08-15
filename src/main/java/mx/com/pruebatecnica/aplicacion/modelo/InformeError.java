package mx.com.pruebatecnica.aplicacion.modelo;

import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InformeError {

	private HttpStatus estatus;

	private List<String> errores;
}
