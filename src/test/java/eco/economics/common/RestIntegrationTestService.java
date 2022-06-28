package eco.economics.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;

import java.net.URI;

public class RestIntegrationTestService {

    public final static MediaType JSON_CONTENT_TYPE = MediaType.parseMediaType(MediaType.APPLICATION_JSON_VALUE);

    @Autowired
    protected TestRestTemplate restTemplate;

    public URI uri(String path) {
        return restTemplate.getRestTemplate().getUriTemplateHandler().expand(path);
    }

    public TestRestTemplate getRestTemplate() {
        return restTemplate;
    }
}
