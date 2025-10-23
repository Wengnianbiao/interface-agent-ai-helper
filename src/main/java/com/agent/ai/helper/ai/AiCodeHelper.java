package com.agent.ai.helper.ai;

import com.agent.ai.helper.utils.PromptUtil;
import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.SystemMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.chat.response.ChatResponse;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AiCodeHelper {

    @Resource
    private ChatModel qwenChatModel;


    public String chatWithBizType(String bizType, String requestFormatter, String responseFormatter) {
        String systemPrompt = PromptUtil.getSystemPrompt(bizType);
        if (systemPrompt == null && systemPrompt.isEmpty()) {
            return "请输入正确的业务类型";
        }
        SystemMessage systemMessage = SystemMessage.from(systemPrompt);
        String userMessageOfString = PromptUtil.generateUserPrompt(requestFormatter, responseFormatter);
        UserMessage userMessage = UserMessage.from(userMessageOfString);
        log.info("chat(): {}", userMessage);
        ChatResponse chatResponse = qwenChatModel.chat(systemMessage, userMessage);
        log.info("chat(): {}", chatResponse);
        AiMessage aiMessage = chatResponse.aiMessage();
        return aiMessage.text();
    }

    public String chatWithMessage(UserMessage userMessage) {
        ChatResponse chatResponse = qwenChatModel.chat(userMessage);
        AiMessage aiMessage = chatResponse.aiMessage();
        return aiMessage.text();
    }
}
