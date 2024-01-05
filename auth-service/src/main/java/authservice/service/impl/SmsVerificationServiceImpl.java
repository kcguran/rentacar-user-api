package authservice.service.impl;

import authservice.service.SmsVerificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class SmsVerificationServiceImpl implements SmsVerificationService {

    private final RedisTemplate<String, String> redisTemplate;
    private final ValueOperations<String, String> valueOperations;

    private static final String SMS_VERIFICATION_PREFIX = "sms_verification:";

    @Override
    public void saveRegisterSmsCodeToCache(String username, String smsCode) {
        String key = SMS_VERIFICATION_PREFIX + username;
        redisTemplate.opsForValue().set(key, smsCode, 5, TimeUnit.MINUTES);
    }

    @Override
    public String getRegisterSmsCodeFromCache(String username) {
        return valueOperations.get(SMS_VERIFICATION_PREFIX + username);
    }
}
