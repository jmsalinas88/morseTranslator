package com.salinas.matias.juan.morse.config;

import java.util.Collections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
    public Docket productApi() {

		return new Docket(DocumentationType.SWAGGER_2)  
		          .select()                                  
		          .apis(RequestHandlerSelectors.basePackage("com.salinas.matias.juan.morse.controlle"))              
		          .paths(PathSelectors.any())                          
		          .build()
		          .apiInfo(this.apiInfo());    
		
		
    }
	
	private ApiInfo apiInfo() {
		Contact contact = new Contact("Juan M. Salinas", "https://github.com/jmsalinas88", "jmsalinas88@gmail.com");
		ApiInfo apiInfo = new ApiInfo("Api Documentation", "<b>Api Morse Translator</b>", " 1.0.0", null, contact, null, null, Collections.emptyList());
	    return  apiInfo;
	}
}
