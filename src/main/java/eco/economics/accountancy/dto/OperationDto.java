package eco.economics.accountancy.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
public class OperationDto implements Serializable {
    private UUID id;
    private String title;
    private Double value;
    private Timestamp date;
    private BaseClassificationDto baseClassification;
    private Set<AdditionalClassificationDto> additionalClassifications;
}
