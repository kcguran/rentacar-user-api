package carservice.mapper;

import carservice.entity.CarDetail;
import carservice.entity.CarEntity;
import carservice.entity.dto.CarDtoResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-21T14:41:13+0300",
    comments = "version: 1.5.0.RC1, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
@Component
public class CarMapperImpl implements CarMapper {

    @Override
    public CarDtoResponse mapCarToCarResponseDto(CarEntity source) {
        if ( source == null ) {
            return null;
        }

        CarDtoResponse carDtoResponse = new CarDtoResponse();

        carDtoResponse.setPersonCount( sourceCarDetailPersonCount( source ) );
        carDtoResponse.setName( source.getName() );
        carDtoResponse.setPrice( source.getPrice() );
        carDtoResponse.setType( source.getType() );

        return carDtoResponse;
    }

    private Integer sourceCarDetailPersonCount(CarEntity carEntity) {
        if ( carEntity == null ) {
            return null;
        }
        CarDetail carDetail = carEntity.getCarDetail();
        if ( carDetail == null ) {
            return null;
        }
        Integer personCount = carDetail.getPersonCount();
        if ( personCount == null ) {
            return null;
        }
        return personCount;
    }
}
