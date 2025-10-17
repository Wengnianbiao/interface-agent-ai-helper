package com.agent.aihelper.controller;

import com.agent.aihelper.service.AiCodeHelperService;
import jakarta.annotation.Resource;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/ai")
public class AiController {

    @Resource
    private AiCodeHelperService aiCodeHelperService;

    @PostMapping("/chat")
    @ResponseBody
    public String chat(@RequestBody ChatRequest request) {
        String bizType = request.getBizType();
        String requestFormatter = request.getRequestFormatter();
        String responseFormatter = request.getResponseFormatter();
        String chatMessage = "这是" + bizType + "接口," + "接口的入参JSON是:" +
                requestFormatter + ",接口的响应JSON是" + responseFormatter;
        System.out.println(chatMessage);
        return aiCodeHelperService.chat(chatMessage);
    }
}
