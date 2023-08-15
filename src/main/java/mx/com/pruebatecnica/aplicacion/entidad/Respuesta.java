package mx.com.pruebatecnica.aplicacion.entidad;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Respuesta {

	private String opcionCorrecta;

	private String respuesta;
}
