package com.agent.ai.helper.controller.request;

import lombok.Data;

/**
 * 业务聊天请求,用于指定业务接口的出入参
 */
@Data
public class BizChatRequest {

    /**
     * 请求格式化,可以是JSON或者XML
     */
    private String requestFormatter;

    /**
     * 响应格式化,可以是JSON或者XML
     */
    private String responseFormatter;
}
