package authservice.other;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@SuppressWarnings({"java:S1068", "java:S1118", "java:S3010"})
@Component
public class SpringUtils {

    private static ApplicationContext applicationContext;
    private static BeanFactory beanFactory;
    private static Environment environment;

    public SpringUtils(ApplicationContext applicationContext,
                       BeanFactory beanFactory,
                       Environment environment) {
        SpringUtils.applicationContext = applicationContext;
        SpringUtils.beanFactory = beanFactory;
        SpringUtils.environment = environment;
    }

    public static boolean isProd() {
        return profileContains("prod");
    }

    public static boolean isMailAvailable() {
        return profileContains("mail");
    }

    public static boolean isSmsAvailable() {
        return profileContains("sms");
    }

    private static boolean profileContains(String profile) {
        return environment.getProperty("spring.profiles.active", "").contains(profile);
    }
}
