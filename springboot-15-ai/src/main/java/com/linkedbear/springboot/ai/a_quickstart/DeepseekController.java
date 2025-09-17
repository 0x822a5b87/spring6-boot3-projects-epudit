package com.linkedbear.springboot.ai.a_quickstart;

import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/deepseek")
public class DeepseekController {
    
    @Autowired
    private OpenAiChatModel openAiChatModel;
    
    @GetMapping("/stream")
//    @GetMapping(value = "/stream", produces = "text/html;charset=GBK") // 解决中文乱码
    public Flux<String> stream(String prompt) {
        return openAiChatModel.stream(prompt);
    }
    
    /*
    // 思考过程暂时无法获取
    @GetMapping("/think")
    public ChatResponse think(String prompt) {
        return openAiChatModel.call(new Prompt(new UserMessage(prompt)));
    }
     */
}
