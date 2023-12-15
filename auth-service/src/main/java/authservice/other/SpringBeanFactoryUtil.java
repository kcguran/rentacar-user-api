package authservice.other;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@SuppressWarnings({"java:S2696"})
@Component
public class SpringBeanFactoryUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(@NonNull ApplicationContext applicationContext) throws BeansException {
        if (SpringBeanFactoryUtil.applicationContext == null) {
            SpringBeanFactoryUtil.applicationContext = applicationContext;
        }
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static Object getBean(String name) {
        if (getApplicationContext() == null) {
            return null;
        }
        return getApplicationContext().getBean(name);
    }

    public static <T> T getBean(Class<T> clazz) {
        if (getApplicationContext() == null) {
            return null;
        }
        return getApplicationContext().getBean(clazz);
    }

    public static <T> T getBean(String name, Class<T> clazz) {
        if (getApplicationContext() == null) {
            return null;
        }
        return getApplicationContext().getBean(name, clazz);
    }
}
