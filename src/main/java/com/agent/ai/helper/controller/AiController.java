package com.agent.ai.helper.controller;

import com.agent.ai.helper.ai.AiCodeHelper;
import com.agent.ai.helper.controller.request.BizChatRequest;
import jakarta.annotation.Resource;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/ai")
public class AiController {

    @Resource
    private AiCodeHelper aiCodeHelper;

    @PostMapping("{bizType}/chat")
    @ResponseBody
    public String chatWithBizType(@PathVariable String bizType, @RequestBody BizChatRequest request) {
        return aiCodeHelper.chatWithBizType(bizType, request.getRequestFormatter(), request.getResponseFormatter());
    }

    @PostMapping("/chat-pdf")
    @ResponseBody
    public String chatWithImage(@RequestParam("file") MultipartFile file) {

        String text = "";
        try {
            PDDocument document = PDDocument.load(file.getInputStream());

            // 提取文本内容
            PDFTextStripper stripper = new PDFTextStripper();
            text = stripper.getText(document);
        } catch (IOException e) {
            System.out.println("pdf解析错误");
        }
        String chatMessage = "这是" + "pdf内容," + "帮我提取其中的建档接口出入参" +
                text + "，然后给我这个新厂商的建档json配置文件，直接给我json结果就好";
        System.out.println(chatMessage);
        return null;
    }
}
