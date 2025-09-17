package com.linkedbear.springboot.aop.f_targetsource;

import org.springframework.aop.framework.autoproxy.TargetSourceCreator;
import org.springframework.aop.framework.autoproxy.target.QuickTargetSourceCreator;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.springframework.aop.config.AopConfigUtils.AUTO_PROXY_CREATOR_BEAN_NAME;

@Configuration
public class TargetSourceConfiguration {
    
    @Bean
    public TargetSourceCreator targetSourceCreator() {
        return new QuickTargetSourceCreator();
    }
    
    @Bean
    public BeanDefinitionRegistryPostProcessor autoProxyCreatorPostProcessor() {
        return new BeanDefinitionRegistryPostProcessor() {
            @Override
            public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) {
                if (registry.containsBeanDefinition(AUTO_PROXY_CREATOR_BEAN_NAME)) {
                    BeanDefinition definition = registry.getBeanDefinition(AUTO_PROXY_CREATOR_BEAN_NAME);
                    TargetSourceCreator[] creators = {targetSourceCreator()};
                    definition.getPropertyValues().add("customTargetSourceCreators", creators);
                }
            }
            
            @Override
            public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) {
            
            }
        };
    }
}
