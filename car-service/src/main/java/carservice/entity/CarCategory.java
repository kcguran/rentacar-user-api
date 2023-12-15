package carservice.entity;

import carservice.entity.shared.DateAudit;
import carservice.enumaration.CategoryName;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@ToString(onlyExplicitlyIncluded = true, callSuper = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@SequenceGenerator(name = "SEQUENCE", sequenceName = "CAR_CATEGORY_ID_SEQ", allocationSize = 1)
@Entity
@Table(name = "car_category")
public class CarCategory extends DateAudit {

    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(generator = "SEQUENCE", strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false, updatable = false)
    @EqualsAndHashCode.Include
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "name")
    private CategoryName name;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "condition_id")
    private Condition condition;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "carCategory")
    private List<CarEntity> carEntities;
}
