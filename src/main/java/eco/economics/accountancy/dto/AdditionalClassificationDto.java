package eco.economics.accountancy.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Builder(toBuilder = true)
public class AdditionalClassificationDto implements Serializable {

    private final UUID id;

    private final UUID operationId;

    @NotNull
    private final RecordDto record;
}
