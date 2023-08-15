package mx.com.pruebatecnica.aplicacion.validador;

import java.time.DateTimeException;
import java.time.ZoneId;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ValidadorIdentificadorZona implements ConstraintValidator<IdentificadorZona, String> {

	@Override
	public void initialize(IdentificadorZona constraintAnnotation) {
	}

	@Override
	public boolean isValid(String valor, ConstraintValidatorContext contexto) {
		try {
			ZoneId.of(valor);
			return true;
		} catch (DateTimeException excepcion) {
			log.error("El valor {} no es un identificador de zona valido.", valor);
			return false;
		}
	}

}
