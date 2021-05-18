package com.oa.pma.validatiton;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD) // works on fields not class
@Retention(RetentionPolicy.RUNTIME) // this tells custom annotation should be available in the byte code
@Constraint(validatedBy = UniqueValidator.class)
public @interface UniqueValue { // @ makes interface annotation
	
	String message() default "Uniques constraint violated...";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
}
