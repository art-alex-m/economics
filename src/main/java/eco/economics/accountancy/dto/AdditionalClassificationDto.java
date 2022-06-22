package eco.economics.accountancy.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public class AdditionalClassificationDto implements Serializable {
    private UUID id;
    private UUID operationId;
    private RecordDto record;
}
