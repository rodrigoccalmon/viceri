package com.viceri.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

// URL Swagger: http://localhost:8080/swagger-ui/index.html#/

@Configuration
public class SwaggerConfig {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.viceri.backend"))
				.paths(PathSelectors.any()).build().apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		ApiInfo apiInfo = new ApiInfoBuilder().title("Teste Viceri").description(
				"Essa foi a API desenvolvida para o teste técnico para empresa Viceri. \n"			
				+ "Obrigado pela oportunidade. \n"
				+ "Atencisamente, \n"
				+ "Rodrigo Calmon  \n\n"
				+ "github: https://github.com/rodrigoccalmon \n"
				+ "linkedin: https://www.linkedin.com/in/rodrigo-calmon/")
				.license("Apache License Version 2.0").licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
				.termsOfServiceUrl("/service.html").version("1.0.0").build();
		return apiInfo;
	}
}