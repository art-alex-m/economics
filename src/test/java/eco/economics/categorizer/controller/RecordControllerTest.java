package eco.economics.categorizer.controller;

import eco.economics.categorizer.dto.ClassifierDto;
import eco.economics.categorizer.dto.RecordDto;
import eco.economics.categorizer.repository.RecordRepository;
import eco.economics.common.IntegrationTestConfiguration;
import eco.economics.common.RestIntegrationTestService;
import eco.economics.common.TestWithDatabase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.jdbc.Sql;

import java.net.URI;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Import(IntegrationTestConfiguration.class)
@Sql("/fixtures/classifier_data.sql")
class RecordControllerTest extends TestWithDatabase {

    private final static String RECORD_URI = "/categorizer/record";

    private final static UUID CLASSIFIER_ID = UUID.fromString("4cea1173-dfc0-4eef-b1f2-af7a59534c28");

    @Autowired
    private RestIntegrationTestService testService;

    @Autowired
    private RecordRepository recordRepository;

    @Test
    public void whenDataCorrect_thenStoreRecordSuccessful() {

        URI uri = testService.uri(RECORD_URI);

        RecordDto requestDto = createRecordDto();

        var response = testService.getRestTemplate()
                .postForEntity(uri, requestDto, RecordDto.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getHeaders().getContentType()).isEqualTo(RestIntegrationTestService.JSON_CONTENT_TYPE);

        RecordDto dto = response.getBody();

        assertThat(dto).isNotNull();
        assertThat(dto.getId()).isInstanceOf(UUID.class);
        assertThat(dto.getTitle()).isEqualTo(requestDto.getTitle());

        assertThat(recordRepository.existsById(dto.getId()))
                .withFailMessage("Record should be created")
                .isTrue();
    }

    private RecordDto createRecordDto() {
        return RecordDto.builder()
                .active(true)
                .title("Test record of classifier")
                .classifier(createClassifierDto())
                .build();
    }

    private ClassifierDto createClassifierDto() {
        return ClassifierDto.builder()
                .id(CLASSIFIER_ID)
                .build();
    }
}