package br.com.kayala.webquarium.core.validator.annotation;

import br.com.kayala.webquarium.core.validator.CompareNumberValidator;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * compare number validator annotation
 *
 * @author kayala
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CompareNumberValidator.class)
public @interface CompareNumber {

	/**
	 *
	 * @return
	 */
	String message() default "{webquarium.validator.comparenumber}";

	/**
	 *
	 * @return
	 */
	Class<?>[] groups() default {};

	/**
	 *
	 * @return
	 */
	Class<? extends Payload>[] payload() default {};

	/**
	 *
	 * @return
	 */
	String field1();

	/**
	 *
	 * @return
	 */
	CompareOperator operator();

	/**
	 *
	 * @return
	 */
	String field2();

	/**
	 *
	 */
	@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
	@Retention(RetentionPolicy.RUNTIME)
	@Documented
	@interface List {

		/**
		 *
		 * @return
		 */
		CompareNumber[] value();
	}
}
