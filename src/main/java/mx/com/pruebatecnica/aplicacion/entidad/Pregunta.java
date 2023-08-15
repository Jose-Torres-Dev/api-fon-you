package mx.com.pruebatecnica.aplicacion.entidad;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(schema = "public", name = "pregunta")
@Data
@NoArgsConstructor
public class Pregunta {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "id")
	private UUID id;

	@Column(name = "id_examen")
	private UUID idExamen;

	@Column(name = "interrogante", nullable = false, length = 300)
	private String interrogante;

	@Column(name = "primera_opcion", nullable = false, length = 300)
	private String primeraOpcion;

	@Column(name = "segunda_opcion", nullable = false, length = 300)
	private String segundaOpcion;

	@Column(name = "tercera_opcion", nullable = false, length = 300)
	private String terceraOpcion;

	@Column(name = "cuarta_opcion", nullable = false, length = 300)
	private String cuartaOpcion;

	@Column(name = "opcion_correcta", nullable = false, length = 1)
	private String opcionCorrecta;

}
