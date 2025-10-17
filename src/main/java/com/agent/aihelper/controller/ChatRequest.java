package com.agent.aihelper.controller;

import lombok.Data;

/**
 * 聊天请求
 */
@Data
public class ChatRequest {

    /**
     * 请求格式化
     */
    private String requestFormatter;

    /**
     * 响应格式化
     */
    private String responseFormatter;

    /**
     * 业务类型:建档、账单
     */
    private String bizType;
}
