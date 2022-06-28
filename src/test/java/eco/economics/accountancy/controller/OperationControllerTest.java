package eco.economics.accountancy.controller;

import eco.economics.accountancy.dto.BaseClassificationDto;
import eco.economics.accountancy.dto.OperationDto;
import eco.economics.accountancy.dto.RecordDto;
import eco.economics.accountancy.repository.OperationRepository;
import eco.economics.common.IntegrationTestConfiguration;
import eco.economics.common.RestIntegrationTestService;
import eco.economics.common.TestWithDatabase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Import(IntegrationTestConfiguration.class)
class OperationControllerTest extends TestWithDatabase {

    private final static String OPERATION_URI = "/accountancy/operation";

    @Autowired
    private RestIntegrationTestService testService;

    @Autowired
    private OperationRepository operationRepository;

    @Test
    public void whenDataCorrect_thenCreateOperationSuccessful() {

        URI uri = testService.uri(OPERATION_URI);

        OperationDto requestDto = createOperation();

        ResponseEntity<OperationDto> response = testService.getRestTemplate()
                .postForEntity(uri, requestDto, OperationDto.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        OperationDto dto = response.getBody();

        assertThat(dto).isNotNull();
        assertThat(dto.getId()).isNotNull();
        assertThat(dto.getTitle()).isEqualTo(requestDto.getTitle());

        assertThat(operationRepository.existsById(dto.getId()))
                .withFailMessage("Operation should be created")
                .isTrue();
    }

    private OperationDto createOperation() {
        BaseClassificationDto baseClassification = BaseClassificationDto.builder()
                .recordTo(RecordDto.builder().id(UUID.randomUUID()).title("RecordTo").build())
                .recordFrom(RecordDto.builder().id(UUID.randomUUID()).title("RecordFrom").build())
                .build();

        OperationDto operationDto = OperationDto.builder()
                .title("Some test operation")
                .value(100.23)
                .date(Timestamp.from(Instant.now()))
                .baseClassification(baseClassification)
                .build();

        return operationDto;
    }
}