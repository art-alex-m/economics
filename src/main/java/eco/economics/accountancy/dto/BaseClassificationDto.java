package eco.economics.accountancy.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder(toBuilder = true)
public class BaseClassificationDto implements Serializable {

    private UUID operationId;

    @NotNull
    private RecordDto recordFrom;

    @NotNull
    private RecordDto recordTo;
}
