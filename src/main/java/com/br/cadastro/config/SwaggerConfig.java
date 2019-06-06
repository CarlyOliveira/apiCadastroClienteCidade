package com.br.cadastro.config;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket cadastroApi() {

		Contact contact = new Contact("Carly Oliveira", "https://github.com/CarlyOliveira",
				"Christianeterno@Hotmail.com");

		@SuppressWarnings("rawtypes")
		List<VendorExtension> vendorExtensions = new ArrayList<>();

		ApiInfo apiInfo = new ApiInfo("CADASTRO API REST", "API REST de cadastro de clientes e cidades", "1.0",
				"Termos de servico", contact, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0",
				vendorExtensions);

		Docket docket = new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo).select()
				.apis(RequestHandlerSelectors.basePackage("com.br.cadastro")).paths(regex("/api.*")).build();

		return docket;

	}

}
