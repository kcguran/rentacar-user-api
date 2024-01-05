package authservice.entity.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtResponseDTO {

    private String accessToken;
    private String username;
    private String tokenType = "Bearer";

    public JwtResponseDTO(String accessToken,String username){
        this.accessToken = accessToken;
        this.username = username;
    }
}
