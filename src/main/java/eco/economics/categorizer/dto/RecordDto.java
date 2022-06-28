package eco.economics.categorizer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class RecordDto implements Serializable {
    private UUID id;

    @NotNull
    private ClassifierDto classifier;

    @NotNull
    @Size(max = 500)
    private String title;

    @NotNull
    private Boolean active;

    private Timestamp createdAt;
    private Timestamp updatedAt;
}
