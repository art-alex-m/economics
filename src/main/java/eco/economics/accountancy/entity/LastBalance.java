package eco.economics.accountancy.entity;

import eco.economics.categorizer.entity.Record;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "last_balance")
public class LastBalance {
    @Id
    @Column(name = "record_id", nullable = false)
    private UUID record_id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "record_id", nullable = false)
    private Record record;

    @Column(name = "date", nullable = false)
    private Timestamp date;

    @Column(name = "updated_at", nullable = false)
    private Timestamp updatedAt;
}