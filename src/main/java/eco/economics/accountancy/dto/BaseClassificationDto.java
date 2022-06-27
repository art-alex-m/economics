package eco.economics.accountancy.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
@Builder
public class BaseClassificationDto implements Serializable {
    private UUID operationId;
    private RecordDto recordFrom;
    private RecordDto recordTo;
}
