package com.linkedbear.springboot.ai.g_mcp;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/mcp")
public class McpController {
    
    @Autowired
    private OllamaChatModel ollamaChatModel;
    
    @Autowired
    private ToolCallbackProvider toolCallbackProvider;
    
    @GetMapping("/call")
    public Flux<String> call(String prompt) {
        ChatClient chatClient = ChatClient.builder(ollamaChatModel).defaultTools(toolCallbackProvider).build();
        return chatClient.prompt(prompt).stream().content();
    }
}
