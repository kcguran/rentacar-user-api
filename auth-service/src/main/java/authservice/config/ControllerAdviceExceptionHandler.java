package authservice.config;

import authservice.exceptions.ErrorControllerException;
import authservice.other.AppResponse;
import jakarta.servlet.RequestDispatcher;
import jakarta.ws.rs.ServiceUnavailableException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerAdviceExceptionHandler {


    @ExceptionHandler(Throwable.class)
    public ResponseEntity<AppResponse<String>> handleThrowable(Throwable e, ServletWebRequest servletWebRequest) {
        AppResponse<String> body = AppResponse.error(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        //logger.error(e.getMessage(), e, new HashMap<>(Map.of("response", body)));
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ErrorControllerException.class)
    public ResponseEntity<AppResponse<String>> handleThrowable(ErrorControllerException e, ServletWebRequest servletWebRequest) {
        String endpoint = String.valueOf(servletWebRequest.getAttribute(RequestDispatcher.FORWARD_REQUEST_URI, RequestAttributes.SCOPE_REQUEST));
        int code = Integer.parseInt(String.valueOf(servletWebRequest.getAttribute(RequestDispatcher.ERROR_STATUS_CODE, RequestAttributes.SCOPE_REQUEST)));
        AppResponse<String> body = AppResponse.error(String.format("%s %s %s", code, servletWebRequest.getHttpMethod(), endpoint));
        return new ResponseEntity<>(body, HttpStatus.valueOf(code));
    }

}
