package com.linkedbear.springboot.ai.f_toolcalling;

import com.linkedbear.springboot.ai.f_toolcalling.service.StoreService;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.tool.definition.ToolDefinition;
import org.springframework.ai.tool.metadata.ToolMetadata;
import org.springframework.ai.tool.method.MethodToolCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.lang.reflect.Method;

@RestController
@RequestMapping("/toolCalling")
public class ToolCallingController {
    
    @Autowired
    private StoreService storeService;
    
    @Autowired
    private OllamaChatModel ollamaChatModel;
    
    @GetMapping("/call")
    public Flux<String> call(String prompt) {
        ChatClient chatClient = ChatClient.builder(ollamaChatModel).defaultTools(storeService).build();
        return chatClient.prompt(prompt).stream().content();
    }
    
    @GetMapping("/test")
    public Flux<String> test(String prompt) {
        ChatClient chatClient = ChatClient.builder(ollamaChatModel).build();
        return chatClient.prompt(prompt).stream().content();
    }
    
    @GetMapping("/programMethodTool")
    public Flux<String> programMethodTool(String prompt) {
        ChatClient chatClient = ChatClient.builder(ollamaChatModel).build();
        Method method = ReflectionUtils.findMethod(storeService.getClass(), "getLocation", String.class);
        ToolDefinition toolDefinition = ToolDefinition.builder(method)
                .description("查询指定商品的位置").build();
        return chatClient.prompt(prompt)
                .tools(MethodToolCallback.builder()
                        .toolDefinition(toolDefinition)
                        .toolMetadata(ToolMetadata.builder().returnDirect(false).build())
                        .toolObject(storeService).toolMethod(method)
                        .build())
                .stream().content();
    }
    
    @GetMapping("/functionCall")
    public Flux<String> functionCall(String prompt) {
        ChatClient chatClient = ChatClient.builder(ollamaChatModel).build();
        return chatClient.prompt(prompt).tools("getStock").stream().content();
    }
    
    @GetMapping("/callcall")
    public String callcall(String prompt) {
        ChatClient chatClient = ChatClient.builder(ollamaChatModel).defaultTools(storeService).build();
        return chatClient.prompt(prompt).call().content();
    }
}
