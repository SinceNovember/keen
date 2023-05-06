package com.simple.keen.config;

import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * .
 *
 * @author SinceNovember
 * @date 2022/12/3
 */
@Configuration(proxyBeanMethods = false)
public class ValidatorConfig {

    @Bean
    public Validator validator() {
        ValidatorFactory validatorFactory = Validation.byProvider(HibernateValidator.class)
            .configure()
            .addProperty("hibernate.validator.fail_fast", "true")
            .buildValidatorFactory();
        return validatorFactory.getValidator();
    }
}
