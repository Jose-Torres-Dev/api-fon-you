package mx.com.pruebatecnica.aplicacion.mapeador;

import lombok.experimental.UtilityClass;
import mx.com.pruebatecnica.aplicacion.entidad.Examen;
import mx.com.pruebatecnica.aplicacion.modelo.NuevoExamen;

@UtilityClass
public class ExamenMapeador {

	public static Examen transformarAEntidad(NuevoExamen examen) {
		var entidad = new Examen();
		entidad.setNombre(examen.getNombre());
		return entidad;
	}

}
