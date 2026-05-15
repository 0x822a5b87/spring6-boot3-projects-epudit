package com.linkedbear.spring.configuration.c_conditional.condition;

import com.linkedbear.spring.configuration.c_conditional.anno.ConditionalOnBean;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.ConfigurationCondition;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.lang.NonNull;

import java.util.Map;

public class OnBeanCondition implements ConfigurationCondition {

    @Override
    public boolean matches(@NonNull ConditionContext context, AnnotatedTypeMetadata metadata) {
        Map<String, Object> attributes = metadata.getAnnotationAttributes(ConditionalOnBean.class.getName());
        // 匹配类型
        assert attributes != null;
        Class<?>[] classes = (Class<?>[]) attributes.get("value");
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        if (beanFactory == null) {
            return false;
        }
        for (Class<?> clazz : classes) {
            if (!beanFactory.containsBeanDefinition(clazz.getName())) {
                return false;
            }
        }
        // 匹配 beanName
        String[] beanNames = (String[]) attributes.get("beanNames");
        for (String beanName : beanNames) {
            if (!beanFactory.containsBeanDefinition(beanName)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public ConfigurationPhase getConfigurationPhase() {
        return ConfigurationPhase.PARSE_CONFIGURATION;
    }
}
