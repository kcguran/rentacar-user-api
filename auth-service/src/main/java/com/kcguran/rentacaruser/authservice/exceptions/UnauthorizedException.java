package com.kcguran.rentacaruser.authservice.exceptions;


public class UnauthorizedException extends AppException{
    public UnauthorizedException(String message) {
        super(message);
    }
}
