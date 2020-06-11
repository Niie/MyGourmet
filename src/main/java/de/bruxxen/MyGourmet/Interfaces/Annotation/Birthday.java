package de.bruxxen.MyGourmet.Interfaces.Annotation;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import de.bruxxen.MyGourmet.Validator.BirthdayValidator;

@Constraint(validatedBy = BirthdayValidator.class)
@Retention(RUNTIME)
@Target({ANNOTATION_TYPE, METHOD, FIELD})
public @interface Birthday {
	String message() default "Wrong birthday";
	Class<?>[] groups() default{};
	Class<? extends Payload>[] payload() default{};
	

}
