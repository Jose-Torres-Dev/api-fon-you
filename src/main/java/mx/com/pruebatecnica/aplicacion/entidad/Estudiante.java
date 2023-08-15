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
@Table(schema = "public", name = "estudiante")
@Data
@NoArgsConstructor
public class Estudiante {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "id")
	private UUID id;

	@Column(name = "nombre", nullable = false, length = 300)
	private String nombre;

	@Column(name = "edad")
	private int edad;

	@Column(name = "ciudad", nullable = false, length = 300)
	private String ciudad;

	@Column(name = "zona_horaria", nullable = false, length = 120)
	private String zonaHoraria;

}
