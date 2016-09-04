package com.rog.webshop.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Target({METHOD, FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = UserSsoIdValidator.class)
@Documented
public @interface UserSsoId {
    String message() default "{com.rog.webshop.validator.UserSsoId.message}";
    Class<?>[] groups() default {};
    public abstract Class<? extends Payload>[] payload() default{};
}

