package carservice.entity.dto;

import carservice.enumaration.GearType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CarDtoResponse {
    private String name;
    private BigDecimal price;
    private Integer type;
    private Integer personCount;
    private Integer suitcaseCount;
    private Integer airbagCount;
    private boolean ABS;
    private GearType gearType;
}


