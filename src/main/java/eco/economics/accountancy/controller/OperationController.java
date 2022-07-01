package eco.economics.accountancy.controller;

import eco.economics.accountancy.dto.OperationDto;
import eco.economics.accountancy.service.OperationCommandService;
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
@RequestMapping(value = "/accountancy/operation", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Accountancy")
public class OperationController {

    @Autowired
    private OperationCommandService operationCommandService;

    @PostMapping
    @Operation(
            summary = "Create operation in log",
            operationId = "storeOperation"
    )
    public OperationDto store(@Valid @RequestBody OperationDto operationDto) {
        return operationCommandService.store(operationDto);
    }

}
