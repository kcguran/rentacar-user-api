package authservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PersonNotValidException extends RuntimeException {

    public PersonNotValidException(String message) {
        super(message);
    }
}
