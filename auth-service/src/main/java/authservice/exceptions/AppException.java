package authservice.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class AppException extends RuntimeException{
    private final HttpStatus httpStatus;
    private final String message;

    public AppException(String message) {
        this.message = message;
        this.httpStatus = HttpStatus.BAD_REQUEST;
    }
}
