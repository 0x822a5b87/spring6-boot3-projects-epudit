package com.linkedbear.spring.configuration.c_conditional.condition;

import com.linkedbear.spring.configuration.c_conditional.component.Boss;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class ExistBossCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        ConfigurableListableBeanFactory factory = context.getBeanFactory();
        if (factory == null) {
            return false;
        }
        return factory.containsBeanDefinition(Boss.class.getName());
    }
}
