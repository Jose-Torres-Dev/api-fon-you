package mx.com.pruebatecnica;

import static org.springframework.boot.SpringApplication.run;

import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal que actua como punto de entrada para ejecutar la aplicacion
 * mediante el metodo main.
 * 
 * @author Jose Luis Torres coronel
 * @since Aug 13, 2023
 * @version 1.0.0
 */
@SpringBootApplication
public class PruebaTecnicaApplication {

	/**
	 * Metodo principal responsable de ejecutar la aplicacion.
	 * 
	 * @param argumentos parametros o valores adicionales a la ejecusion de la
	 *                   aplicacion.
	 */
	public static void main(String[] argumentos) {
		final Class<PruebaTecnicaApplication> clase = PruebaTecnicaApplication.class;
		run(clase, argumentos);
	}

}
