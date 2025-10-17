package com.agent.aihelper.service;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.spring.AiService;
import reactor.core.publisher.Flux;

@AiService
public interface AiCodeHelperService {

    @SystemMessage(fromResource = "creatarchive/json-createarchives-prompt.txt")
    String chat(String userMessage);

    @SystemMessage(fromResource = "creatarchive/json-createarchives-prompt.txt")
    Flux<String> chatStream(String userMessage);
}
