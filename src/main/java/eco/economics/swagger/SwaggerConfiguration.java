package eco.economics.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public SecurityFilterChain filterChainSwagger(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/swagger-ui/**").permitAll()
                .antMatchers("/v3/api-docs/**").permitAll();

        return http.build();
    }

    @Bean
    public OpenAPI currentOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Economics REST API").version("1.0.0"));
    }

}
