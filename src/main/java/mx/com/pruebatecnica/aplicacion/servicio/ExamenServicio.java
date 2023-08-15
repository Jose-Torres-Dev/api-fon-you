package mx.com.pruebatecnica.aplicacion.servicio;

import mx.com.pruebatecnica.aplicacion.modelo.ExamenRegistrado;
import mx.com.pruebatecnica.aplicacion.modelo.NuevoExamen;

public interface ExamenServicio {

	ExamenRegistrado crearExamen(NuevoExamen nuevoExamen);

}
