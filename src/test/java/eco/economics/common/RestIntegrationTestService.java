package eco.economics.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.net.URI;

public class RestIntegrationTestService {

    @Autowired
    protected TestRestTemplate restTemplate;

    public URI uri(String path) {
        return restTemplate.getRestTemplate().getUriTemplateHandler().expand(path);
    }

    public TestRestTemplate getRestTemplate() {
        return restTemplate;
    }
}
