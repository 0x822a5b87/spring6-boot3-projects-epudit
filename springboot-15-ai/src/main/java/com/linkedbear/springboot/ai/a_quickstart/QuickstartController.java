package com.linkedbear.springboot.ai.a_quickstart;

import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quickstart")
public class QuickstartController {
    
    @Autowired
    private OpenAiChatModel openAiChatModel;
    
    @GetMapping("/test")
    public String test(String prompt) {
        return openAiChatModel.call(prompt);
    }
}
