package reservationservice.entity.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class ReservationResponseDto {

    private Date startDate;
    private Date endDate;
    private BigDecimal price;
    private String firstName;
    private String lastName;
    private String carName;
    private String locationName;
}
