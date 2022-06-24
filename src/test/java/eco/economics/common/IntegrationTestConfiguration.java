package eco.economics.common;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.testcontainers.junit.jupiter.Testcontainers;

@TestConfiguration
@Testcontainers
public class IntegrationTestConfiguration {

    @Bean
    @Scope("singleton")
    public RestIntegrationTestService restIntegrationTestService() {
        return new RestIntegrationTestService();
    }
}
