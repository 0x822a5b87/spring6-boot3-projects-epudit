package com.linkedbear.springboot.ai.b_params;

import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/params")
public class ParamsController {
    
    @Autowired
    private OpenAiChatModel openAiChatModel;
    
    @GetMapping("/test")
    public String test(String prompt) {
        return openAiChatModel.call(prompt);
    }
    
    @GetMapping("/temperature")
    public String temperature(String prompt, Double temperature) {
        ChatOptions options = ChatOptions.builder().temperature(temperature).build();
        return openAiChatModel.call(new Prompt(prompt, options)).getResult().getOutput().getText();
    }
}
