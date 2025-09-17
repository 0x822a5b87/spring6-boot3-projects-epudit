package com.linkedbear.springboot.ai.e_rag;

import org.springframework.ai.document.Document;
import org.springframework.ai.ollama.OllamaEmbeddingModel;
import org.springframework.ai.reader.ExtractedTextFormatter;
import org.springframework.ai.reader.TextReader;
import org.springframework.ai.reader.pdf.PagePdfDocumentReader;
import org.springframework.ai.reader.pdf.config.PdfDocumentReaderConfig;
import org.springframework.ai.reader.tika.TikaDocumentReader;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.SimpleVectorStore;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.io.ClassPathResource;

import java.util.List;

@Configuration(proxyBeanMethods = false)
public class RagConfiguration {
    
    @Bean
    public VectorStore vectorStore(OllamaEmbeddingModel ollamaEmbeddingModel) {
        return SimpleVectorStore.builder(ollamaEmbeddingModel).build();
    }
    
    @Bean
    public ApplicationListener<ContextRefreshedEvent> loadDocumentListener(VectorStore vectorStore) {
        
        return event -> {
            TokenTextSplitter splitter = new TokenTextSplitter();
            
            TextReader textReader = new TextReader(new ClassPathResource("/rag/小知识.txt"));
            List<Document> documents = textReader.read();
            vectorStore.add(splitter.transform(documents));
            
            // 读取PDF文档
            PagePdfDocumentReader pdfReader = new PagePdfDocumentReader(
                    "/rag/Spring如何在运行期动态注册新的数据源？.pdf",
                    PdfDocumentReaderConfig.builder().withPageTopMargin(1)
                            .withPageBottomMargin(1).build());
            vectorStore.add(splitter.transform(pdfReader.read()));
            // 读取HTML文档
            TikaDocumentReader tikaReader = new TikaDocumentReader("/rag/MyBatis的一级缓存竟然还会引来麻烦？.html",
                    ExtractedTextFormatter.builder().build());
            vectorStore.add(splitter.transform(tikaReader.get()));
        };
    }
}
