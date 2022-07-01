package eco.economics.accountancy.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder(toBuilder = true)
public class OperationDto implements Serializable {

    private UUID id;

    @NotEmpty
    @Size(max = 500)
    private String title;

    @NotNull
    private Double value;

    @NotNull
    private Timestamp date;

    @NotNull
    private BaseClassificationDto baseClassification;

    private Set<AdditionalClassificationDto> additionalClassifications;
}
