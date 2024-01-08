package reservationservice.entity;

import jakarta.persistence.*;
import lombok.*;
import reservationservice.entity.shared.DateAudit;

import java.math.BigDecimal;
import java.util.Date;

@Data
@ToString(onlyExplicitlyIncluded = true, callSuper = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@SequenceGenerator(name = "SEQUENCE", sequenceName = "CAR_CATEGORY_ID_SEQ", allocationSize = 1)
@Entity
@Table(name = "car_category")
public class Reservation extends DateAudit {

    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(generator = "SEQUENCE", strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false, updatable = false)
    @EqualsAndHashCode.Include
    private Long id;

    private Date startDate;

    private Date endDate;

    private BigDecimal price;

    private Long userId;

    private Long carId;

    private Long locationId;
}
