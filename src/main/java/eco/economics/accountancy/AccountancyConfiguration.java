package eco.economics.accountancy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class AccountancyConfiguration {

    @Bean
    public SecurityFilterChain filterChainAccountancy(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/accountancy/operation/**").permitAll();

        http.csrf().disable();

        return http.build();
    }

}
