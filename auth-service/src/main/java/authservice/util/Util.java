package authservice.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.NONE)
public class Util {

    public static String getRandomCode(int size) {
        String randomCode = UUID.randomUUID().toString().replace("-", "");
        return randomCode.substring((10 - size) - 10);
    }

    public static String smsFill(String smsCode) {
        return "Doğrulama Kodunuz: " + smsCode;
    }

}
