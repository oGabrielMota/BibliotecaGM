package br.com.aceleragep.BibliotecaGM;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;



@Configuration
public class CongfigSwagger {

		@Bean
		public Docket api() {
			return new Docket(DocumentationType.SWAGGER_2)
					.select()
					.apis(RequestHandlerSelectors.basePackage("br.com.aceleragep.BibliotecaGM"))
					.paths(PathSelectors.any())
					.build();
		}
		
		
		@Bean
		OpenAPI bibliotecaOpenAPI() {
			return new OpenAPI()
					.info(new Info().title("API Biblioteca Gabriel Mota").description("Projeto de API de uma biblioteca").version("v1.1"));
		}
}
