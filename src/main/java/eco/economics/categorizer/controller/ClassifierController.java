package eco.economics.categorizer.controller;

import eco.economics.categorizer.dto.ClassifierDto;
import eco.economics.categorizer.service.ClassifierCommandService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/categorizer/classifier", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Categorizer")
public class ClassifierController {

    @Autowired
    private ClassifierCommandService classifierCommandService;

    @PostMapping
    @Operation(
            operationId = "storeClassifier",
            summary = "Create new classifier"
    )
    public ClassifierDto store(@Valid @RequestBody ClassifierDto classifierDto) {
        return classifierCommandService.store(classifierDto);
    }
}
