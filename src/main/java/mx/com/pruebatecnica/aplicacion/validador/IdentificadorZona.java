package mx.com.pruebatecnica.aplicacion.validador;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = ValidadorIdentificadorZona.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface IdentificadorZona {
	
    String message() default "Identificador de zona no valido";
    
    Class<?>[] groups() default {};
    
    Class<? extends Payload>[] payload() default {};

}
