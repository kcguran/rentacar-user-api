package reservationservice.entity.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class ReservationCreateDto {

    private Date startDate;
    private Date endDate;
    private BigDecimal price;
    private Long carId;
}
