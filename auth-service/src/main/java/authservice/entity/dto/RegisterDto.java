package authservice.entity.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterDto {

    private String username;
    private String firstname;
    private String lastname;
    private String phone;
    private String identityNumber;
    private String email;
    private boolean enabled;
}
