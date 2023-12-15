package carservice.entity;

import carservice.entity.shared.DateAudit;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Data
@ToString(onlyExplicitlyIncluded = true, callSuper = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@SequenceGenerator(name = "SEQUENCE", sequenceName = "CAR_ID_SEQ", allocationSize = 1)
@Entity
@Table(name = "car")
public class CarEntity extends DateAudit {

    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(generator = "SEQUENCE", strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false, updatable = false)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "type")
    private Integer type;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "car_detail_id")
    private CarDetail carDetail;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_category_id")
    private CarCategory carCategory;
}
