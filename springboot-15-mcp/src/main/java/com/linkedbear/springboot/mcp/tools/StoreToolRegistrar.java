package com.linkedbear.springboot.mcp.tools;

import com.linkedbear.springboot.mcp.service.StoreService;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class StoreToolRegistrar {
    
    @Bean
    public ToolCallbackProvider storeToolCallbackProvider(StoreService storeService) {
        return MethodToolCallbackProvider.builder().toolObjects(storeService).build();
    }
}
