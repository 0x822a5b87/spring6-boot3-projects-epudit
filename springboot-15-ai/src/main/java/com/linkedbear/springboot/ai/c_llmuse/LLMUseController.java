package com.linkedbear.springboot.ai.c_llmuse;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.SafeGuardAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.InMemoryChatMemory;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.converter.MapOutputConverter;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Map;

import static org.springframework.ai.chat.client.advisor.AbstractChatMemoryAdvisor.CHAT_MEMORY_CONVERSATION_ID_KEY;

@RestController
@RequestMapping("/llmuse")
public class LLMUseController {
    
    @Autowired
    private OpenAiChatModel openAiChatModel;
    
    @GetMapping("/chatclient")
    public String chatclient(String prompt) {
        return ChatClient.create(openAiChatModel).prompt().user(prompt).call().content();
    }
    
    @GetMapping("/chatclient1")
    public String chatclient1(String prompt) {
        return ChatClient.builder(openAiChatModel).build()
                .prompt().user(prompt).call().content();
    }
    
    @GetMapping("/chatclient2")
    public String chatclient2(String prompt) {
        return ChatClient.builder(openAiChatModel)
                .defaultSystem("你是一名擅长讲技术笑话的程序员")
                .build().prompt().user(prompt).call().content();
    }
    
    @GetMapping("/chatclient3")
    public String chatclient3(String prompt) {
        return ChatClient.create(openAiChatModel).prompt()
                .advisors(new SafeGuardAdvisor(List.of("不好", "很差")))
                .user(prompt).call().content();
    }
    
    
    @GetMapping("/tempMultiRound")
    public String tempMultiRound() {
        return ChatClient.create(openAiChatModel).prompt()
                .messages(new UserMessage("讲个笑话"),
                        new AssistantMessage("为什么数学书总是很难过？因为它有太多的问题。"),
                        new UserMessage("再讲一个有关程序员的笑话"))
                .call().content();
    }
    
    private ChatMemory memory = new InMemoryChatMemory();
    
    @GetMapping("/multiRound")
    public String multiRound(String prompt, String chatSessionId) {
        return ChatClient.create(openAiChatModel).prompt()
                .advisors(a -> a.advisors(new MessageChatMemoryAdvisor(memory))
                        .param(CHAT_MEMORY_CONVERSATION_ID_KEY, chatSessionId))
                .user(prompt).call().content();
    }
    
    @GetMapping("/structuredOutput")
    public Map<String, Object> structuredOutput(String prompt) {
        return ChatClient.create(openAiChatModel).prompt()
                .user(prompt).call().entity(new MapOutputConverter());
    }
}
