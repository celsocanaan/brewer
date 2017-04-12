package com.algaworks.brewer.validacao;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.OverridesAttribute;
import javax.validation.Payload;
import javax.validation.constraints.Pattern;

@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
@Pattern(regexp = "([0-9]{8})?")   //? diz para só usar se o campo for informado
public @interface CEP {

	@OverridesAttribute(constraint = Pattern.class, name = "message")
	String message() default "CEP deve seguir o padrão 99999-999";

	//Tem que colocar as instruções abaixo, senão dá erro.
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};

}
