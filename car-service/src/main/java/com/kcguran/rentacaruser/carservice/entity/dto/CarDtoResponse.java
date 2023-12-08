package com.kcguran.rentacaruser.carservice.entity.dto;

import com.kcguran.rentacaruser.carservice.enumaration.GearType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
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


