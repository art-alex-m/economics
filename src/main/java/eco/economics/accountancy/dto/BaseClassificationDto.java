package eco.economics.accountancy.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public class BaseClassificationDto implements Serializable {
    private UUID operationId;
    private RecordDto recordFrom;
    private RecordDto recordTo;
}
