package authservice.service;

public interface SmsVerificationService {

    void saveRegisterSmsCodeToCache(String username, String smsCode);

    String getRegisterSmsCodeFromCache(String username);
}
