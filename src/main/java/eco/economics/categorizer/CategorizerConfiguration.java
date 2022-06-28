package eco.economics.categorizer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class CategorizerConfiguration {

    @Bean
    public SecurityFilterChain filterChainClassifier(HttpSecurity http) throws Exception {

        http.antMatcher("/categorizer/**")
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/categorizer/classifier*").permitAll()
                .antMatchers("/categorizer/record*").permitAll()
                .anyRequest().denyAll();

        return http.build();
    }
}
