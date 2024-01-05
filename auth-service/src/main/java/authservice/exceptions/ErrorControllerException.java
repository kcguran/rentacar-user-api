package authservice.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ErrorControllerException extends RuntimeException {
    public ErrorControllerException() {
        super("ErrorControllerException");
    }
}
