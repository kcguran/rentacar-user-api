package carservice.entity;

import carservice.entity.shared.DateAudit;
import jakarta.persistence.*;
import lombok.*;

@Data
@ToString(onlyExplicitlyIncluded = true, callSuper = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@SequenceGenerator(name = "SEQUENCE", sequenceName = "CONDITION_ID_SEQ", allocationSize = 1)
@Entity
@Table(name = "condition")
public class Condition extends DateAudit {

    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(generator = "SEQUENCE", strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false, updatable = false)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "distance")
    private Long distance;

    @Column(name = "minumum_age")
    private String minimumAge;

    @Column(name = "licence_age")
    private String licenceAge;

    @Column(name = "credit_card_quantity")
    private Integer creditCardQuantity;
}
