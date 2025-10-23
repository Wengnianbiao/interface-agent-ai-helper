package com.agent.ai.helper.utils;

import com.agent.ai.helper.enums.BizType;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class PromptUtil {

    public static String getSystemPrompt(String bizType) {
        BizType curBizType = BizType.fromString(bizType.replace("-", "_"));
        if (curBizType == null) {
            return null;
        }

        // 根据枚举值构建文件路径
        String promptFileName = curBizType.name().toLowerCase() + ".txt";
        String resourcePath = "systemprompt/" + promptFileName;

        try {
            ClassPathResource resource = new ClassPathResource(resourcePath);
            return StreamUtils.copyToString(resource.getInputStream(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException("读取提示词文件失败: " + resourcePath, e);
        }
    }

    public static String generateUserPrompt(String requestFormatter, String responseFormatter) {
        return """
        新厂商接口的入参请求格式为：
        """ + requestFormatter + """
        响应格式为：
        """ + responseFormatter;
    }
}
