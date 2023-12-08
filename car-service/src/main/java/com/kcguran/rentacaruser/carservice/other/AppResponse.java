package com.kcguran.rentacaruser.carservice.other;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.NONE)
public class AppResponse<T> {

    private T data;
    private boolean success;

    private AppResponse(T data, boolean success) {
        this.data = data;
        this.success = success;
    }

    public static <T> AppResponse<T> success(T data) {
        return new AppResponse<>(data, true);
    }

    public static <T> AppResponse<T> error(T data) {
        return new AppResponse<>(data, false);
    }
}
