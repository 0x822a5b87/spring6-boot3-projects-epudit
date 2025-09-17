package com.linkedbear.springboot.ai.e_rag;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.vectorstore.QuestionAnswerAdvisor;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/rag")
public class RagController {
    
    @Autowired
    private OllamaChatModel ollamaChatModel;
    
    @Autowired
    private VectorStore vectorStore;
    
    @GetMapping("/ask")
    public Flux<String> ask(String prompt) {
        ChatClient chatClient = ChatClient.builder(ollamaChatModel)
                .defaultAdvisors(new QuestionAnswerAdvisor(vectorStore)).build();
        return chatClient.prompt(prompt).stream().content();
    }
}
