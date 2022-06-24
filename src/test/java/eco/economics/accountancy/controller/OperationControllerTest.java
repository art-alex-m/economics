package eco.economics.accountancy.controller;

import eco.economics.accountancy.dto.OperationDto;
import eco.economics.common.IntegrationTestConfiguration;
import eco.economics.common.RestIntegrationTestService;
import eco.economics.common.TestWithDatabase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Import(IntegrationTestConfiguration.class)
class OperationControllerTest extends TestWithDatabase {

    private final static String OPERATION_URI = "/accountancy/operation";

    @Autowired
    private RestIntegrationTestService testService;

    @Test
    void createOperationWhenDataIsCorrect() {

        var uri = testService.uri(OPERATION_URI);

        var response = testService.getRestTemplate().exchange(
                RequestEntity.post(uri).body(""),
                OperationDto.class
        );

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }
}