package eco.economics.categorizer.controller;

import eco.economics.categorizer.dto.ClassifierDto;
import eco.economics.categorizer.repository.ClassifierRepository;
import eco.economics.common.IntegrationTestConfiguration;
import eco.economics.common.RestIntegrationTestService;
import eco.economics.common.TestWithDatabase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;

import java.net.URI;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Import(IntegrationTestConfiguration.class)
class ClassifierControllerTest extends TestWithDatabase {

    private final static String CLASSIFIER_URI = "/categorizer/classifier";

    @Autowired
    private RestIntegrationTestService testService;

    @Autowired
    private ClassifierRepository classifierRepository;

    @Test
    public void whenDataCorrect_thenStoreClassifierSuccessful() {

        URI uri = testService.uri(CLASSIFIER_URI);

        ClassifierDto requestDto = createClassifierDto();

        var response = testService.getRestTemplate()
                .postForEntity(uri, requestDto, ClassifierDto.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getHeaders().getContentType())
                .isEqualTo(RestIntegrationTestService.JSON_CONTENT_TYPE);

        ClassifierDto dto = response.getBody();

        assertThat(dto).isNotNull();
        assertThat(dto.getId()).isNotNull();
        assertThat(dto.getTitle()).isEqualTo(requestDto.getTitle());
        assertThat(dto.getDescription()).isEqualTo(requestDto.getDescription());

        assertThat(classifierRepository.existsById(dto.getId()))
                .withFailMessage("Classifier item should be created")
                .isTrue();
    }

    private ClassifierDto createClassifierDto() {
        return ClassifierDto.builder()
                .active(true)
                .main(false)
                .title("Test classification item")
                .description("Test classification item description")
                .build();
    }
}