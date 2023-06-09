package eco.economics.accountancy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class AccountancyConfiguration {

    @Bean
    public SecurityFilterChain filterChainAccountancy(HttpSecurity http) throws Exception {

        http.antMatcher("/accountancy/**")
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/accountancy/operation/**").permitAll()
                .anyRequest().denyAll();

        return http.build();
    }

}
