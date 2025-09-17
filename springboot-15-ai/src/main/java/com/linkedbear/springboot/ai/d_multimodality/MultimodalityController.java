package com.linkedbear.springboot.ai.d_multimodality;

import org.springframework.ai.audio.transcription.AudioTranscriptionPrompt;
import org.springframework.ai.audio.transcription.AudioTranscriptionResponse;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.content.Media;
import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.openai.OpenAiAudioSpeechModel;
import org.springframework.ai.openai.OpenAiAudioTranscriptionModel;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.OpenAiImageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/multimodality")
public class MultimodalityController {
    
    @Autowired
    private OpenAiImageModel openAiImageModel;
    
    @GetMapping("/textToImage")
    public String textToImage(String prompt) {
        ImageResponse imageResponse = openAiImageModel.call(new ImagePrompt(prompt));
        return imageResponse.getResult().getOutput().getUrl();
    }
    
    @Autowired
    private OpenAiAudioSpeechModel audioSpeechModel;
    
    @GetMapping("/textToSpeech")
    public String textToSpeech(String prompt) throws IOException {
        byte[] mp3 = audioSpeechModel.call(prompt);
        FileCopyUtils.copy(mp3, new File("D:/textToSpeech.mp3"));
        return "success";
    }
    
    @Autowired
    private OpenAiAudioTranscriptionModel audioTranscriptionModel;
    
    @GetMapping("/speechToText")
    public String speechToText() {
        AudioTranscriptionResponse transcriptionResponse = audioTranscriptionModel.call(
                new AudioTranscriptionPrompt(new ClassPathResource("/textToSpeech.mp3")));
        return transcriptionResponse.getResult().getOutput();
    }
    
    @Autowired
    private OpenAiChatModel openAiChatModel;
    
    @GetMapping("/multimodality")
    public String multimodality() {
        ClassPathResource picture = new ClassPathResource("/bearReadBook.png");
        Media media = new Media(MediaType.IMAGE_PNG, picture);
        UserMessage message = new UserMessage("你从图片中看到了什么", media);
        ChatResponse response = openAiChatModel.call(new Prompt(message));
        return response.getResult().getOutput().getText();
    }
}
