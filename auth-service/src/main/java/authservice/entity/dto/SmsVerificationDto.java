package authservice.entity.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SmsVerificationDto extends LoginDto{

    private String smsCode;
}
