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
import org.springframework.test.context.jdbc.Sql;

import java.net.URI;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Import(IntegrationTestConfiguration.class)
@Sql(scripts = {"/fixtures/classifier_data.sql", "/fixtures/records_data.sql"})
class OperationControllerTest extends TestWithDatabase {

    private final static String OPERATION_URI = "/accountancy/operation";

    private final static UUID RECORD_FROM = UUID.fromString("4cea1173-dfc0-4eef-b1f2-af7a59534c31");
    private final static UUID RECORD_TO = UUID.fromString("4cea1173-dfc0-4eef-b1f2-af7a59534c32");

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
                .recordTo(RecordDto.builder().id(RECORD_TO).build())
                .recordFrom(RecordDto.builder().id(RECORD_FROM).build())
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