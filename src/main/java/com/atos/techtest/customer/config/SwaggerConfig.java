package com.atos.techtest.customer.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * This configuration class is used to configure the 
 * Swagger for the Customer Controller.
 * 
 * @author Jateen Udeshi
 *
 */
@EnableSwagger2
@Configuration

public class SwaggerConfig {
	@Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.atos.techtest.customer"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(getApiInfo());
    }
	
	private ApiInfo getApiInfo() {
		VendorExtension<String> extension = null;
		return new ApiInfo(
	            "Customer API",
	            "This is provision of simple HTTP based RESTful APIs that provides 3 operations for managing customers i.e. ADD/DELETE/LIST",
	            "0.0.1-SNAPSHOT",
	            "http://localhost:8080/swagger-ui.html",
	            new Contact("Jateen Udeshi","http://localhost:8080/swagger-ui.html","jateen5@gmail.com"),
	            "Licence",
	            "http://localhost:8080/swagger-ui.html",
	            Collections.emptyList());
	}
}
