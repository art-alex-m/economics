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
@Table(name = "base_classification")
public class BaseClassification {
    @Id
    @Column(name = "operation_id", nullable = false, unique = true)
    private UUID operationId;

    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "record_id_from", nullable = false)
    private Record recordFrom;

    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "record_id_to", nullable = false)
    private Record recordTo;
}