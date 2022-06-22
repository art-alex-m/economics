package eco.economics.accountancy.entity;

import eco.economics.categorizer.entity.Record;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "additional_classification")
public class AdditionalClassification {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "operation_id", nullable = false)
    private UUID operationId;

    @Column(name = "record_id", nullable = false)
    private UUID recordId;

    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "record_id", nullable = false, insertable = false, updatable = false)
    private Record record;
}