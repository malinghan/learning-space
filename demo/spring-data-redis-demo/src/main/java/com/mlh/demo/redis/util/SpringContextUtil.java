package com.mlh.demo.redis.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringContextUtil implements ApplicationContextAware {

    /**
     * Spring应用上下文环境
     */
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextUtil.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * 根据实体名称获取对象
     * @param beanName 实体名称
     * @return
     * @throws BeansException
     */
    public static Object getBean(String beanName) throws BeansException {
        return applicationContext.getBean(beanName);
    }

    /**
     * 根据接口class 获取对象
     * @param classz 实体class
     * @return
     * @throws BeansException
     */
    public static <T> T getBean(Class<T> classz) throws BeansException {
        return applicationContext.getBean(classz);
    }
}
