package carservice.entity;

import carservice.entity.shared.DateAudit;
import carservice.enumaration.GearType;
import jakarta.persistence.*;
import lombok.*;

@Data
@ToString(onlyExplicitlyIncluded = true, callSuper = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@SequenceGenerator(name = "SEQUENCE", sequenceName = "CAR_DETAIL_ID_SEQ", allocationSize = 1)
@Entity
@Table(name = "car_detail")
public class CarDetail extends DateAudit {

    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(generator = "SEQUENCE", strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false, updatable = false)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "person_count")
    private Integer personCount;

    @Column(name = "suitcase_count")
    private Integer suitcaseCount;

    @Column(name = "airbag_count")
    private Integer airbagCount;

    @Column(name = "abs")
    private boolean ABS;

    @Enumerated(EnumType.STRING)
    @Column(name = "gear_type")
    private GearType gearType;
}
