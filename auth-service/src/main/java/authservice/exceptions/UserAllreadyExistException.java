package authservice.exceptions;

public class UserAllreadyExistException extends AppException{

    public UserAllreadyExistException(String message) {
        super(message);
    }
}
