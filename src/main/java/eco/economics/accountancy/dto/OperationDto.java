package eco.economics.accountancy.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Builder(toBuilder = true)
public class OperationDto implements Serializable {

    private final UUID id;

    @NotEmpty
    private final String title;

    @NotNull
    private final Double value;

    @NotNull
    @Size(max = 500)
    private final Timestamp date;

    @NotNull
    private final BaseClassificationDto baseClassification;

    private final Set<AdditionalClassificationDto> additionalClassifications;
}
