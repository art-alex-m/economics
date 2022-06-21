package eco.economics.accountancy.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(value = "/accountancy/operation", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Accountancy")
public class OperationController {

    @PostMapping
    @Operation(
            summary = "Create operation in log",
            operationId = "storeOperation"
    )
    public UUID store() {
        return UUID.randomUUID();
    }

}
