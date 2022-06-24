package eco.economics.accountancy.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "operations")
public class Operation {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "title", nullable = false, length = 500)
    private String title;

    @Column(name = "value", nullable = false)
    private Double value;

    @Column(name = "date", nullable = false)
    private Timestamp date;

    @Column(name = "updated_at", nullable = false)
    private Timestamp updatedAt;

    @OneToOne(fetch = FetchType.LAZY)
    private BaseClassification baseClassification;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<AdditionalClassification> additionalClassifications = new LinkedHashSet<>();
}