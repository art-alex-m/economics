package eco.economics.accountancy.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
@Builder
public class RecordDto implements Serializable {
    private UUID id;
    private String title;
}
