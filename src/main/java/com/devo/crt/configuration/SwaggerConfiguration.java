package com.devo.crt.configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Configurations for Swagger 2.0 API documentation.
 * 
 * @see http://localhost:5000/swagger-ui.html for pretty doc.
 * @see http://http://localhost:5000/v2/api-docs for Json formatted
 *      documentation
 * 
 * @author rizahorasan@gmail.com
 * @since Dec 2019
 * 
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	public static final Contact API_INFO_CONTACT = new Contact("Riza Horasan", "", "rizahorasan@gmail.com");
	@SuppressWarnings("rawtypes")
	public static final ApiInfo API_INFO = new ApiInfo("Competitor Ranking APIs",
			"Competitor Ranking APIs provides features for Competitor Ranking Tool.", "1.0", "urn:tos",
			API_INFO_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0",
			new ArrayList<VendorExtension>());
	private static final Set<String> PRODUCE_JSON = new HashSet<String>(Arrays.asList("application/json"));
	private static final Set<String> CONSUMES_JSON = new HashSet<String>(Arrays.asList("application/json"));;

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(API_INFO).produces(PRODUCE_JSON).consumes(CONSUMES_JSON);
	}
}
