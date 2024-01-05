package authservice.config;

import authservice.other.AppResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;

@ControllerAdvice
public class ControllerAdviceExceptionHandler {


    @ExceptionHandler(Throwable.class)
    public ResponseEntity<AppResponse<String>> handleThrowable(Throwable e, ServletWebRequest servletWebRequest) {
        AppResponse<String> body = AppResponse.error(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        //logger.error(e.getMessage(), e, new HashMap<>(Map.of("response", body)));
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
