
package com.helmes.german.novikov.TestWork.applicaton.config.web.openapi;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiDocsConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        var version = getClass().getPackage().getImplementationVersion();
        if(version == null || version.isEmpty()) version = "1.0.0";
        var components = new Components();
        return new OpenAPI()
            .components(components)
            .info(new Info().version(version).title("Test Work Helmes").description("Test Work for Helmes"));
    }

    static {
        io.swagger.v3.core.jackson.ModelResolver.enumsAsRef = true;
    }
}
