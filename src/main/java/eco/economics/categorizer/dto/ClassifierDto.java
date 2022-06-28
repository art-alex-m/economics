package eco.economics.categorizer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ClassifierDto implements Serializable {

    private UUID id;

    @NotEmpty
    @Size(max = 500)
    private String title;

    @NotNull
    private Boolean active;

    @NotNull
    private Boolean main;

    private String description;

    private Timestamp createdAt;

    private Timestamp updatedAt;
}
