package eco.economics.categorizer.controller;

import eco.economics.categorizer.dto.RecordDto;
import eco.economics.categorizer.service.RecordCommandService;
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
@RequestMapping(value = "/categorizer/record", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Categorizer")
public class RecordController {

    @Autowired
    private RecordCommandService recordCommandService;

    @PostMapping
    @Operation(
            summary = "Create record of classifier",
            operationId = "createRecord"
    )
    public RecordDto store(@Valid @RequestBody RecordDto recordDto) {
        return recordCommandService.store(recordDto);
    }

}
