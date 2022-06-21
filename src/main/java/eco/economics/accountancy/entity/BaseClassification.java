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
    @Column(name = "operation_id", nullable = false)
    private UUID id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "operation_id", nullable = false)
    private Operation operation;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "record_id_from", nullable = false)
    private Record recordIdFrom;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "record_id_to", nullable = false)
    private Record recordIdTo;
}