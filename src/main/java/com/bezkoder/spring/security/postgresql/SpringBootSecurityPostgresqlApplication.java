package com.bezkoder.spring.security.postgresql;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@OpenAPIDefinition(info = @Info(title = "Tutorial API", version = "2.0", description = "Tutorial Information"))
//@SecurityScheme(name = "tutorialapi", scheme = "", type = SecuritySchemeType.HTTP, in = SecuritySchemeIn.HEADER)
public class SpringBootSecurityPostgresqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityPostgresqlApplication.class, args);
	}

}
