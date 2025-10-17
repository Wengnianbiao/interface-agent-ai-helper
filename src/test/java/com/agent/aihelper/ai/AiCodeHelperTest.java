package com.agent.aihelper.ai;

import com.agent.aihelper.service.AiCodeHelperService;
import dev.langchain4j.data.message.ImageContent;
import dev.langchain4j.data.message.TextContent;
import dev.langchain4j.data.message.UserMessage;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AiCodeHelperTest {

    @Resource
    private AiCodeHelperService aiCodeHelperService;


    @Test
    public void chat() {
        String result = aiCodeHelperService.chat("入参为{\n" +
                "    \"orgId\": 70296004,\n" +
                "    \"campusId\": 80298003,\n" +
                "    \"doctorJobNumber\": \"stcs888\",\n" +
                "    \"birthDate\": \"1968-06-18 00:00:00\",\n" +
                "    \"workplaceAddress\": \"无\",\n" +
                "    \"nationalityCode\": \"GB/T2659.156\",\n" +
                "    \"genderCode\": \"GB/T2261.1.1\",\n" +
                "    \"telecomTypeCode\": \"FH0344.01\",\n" +
                "    \"residentCardInfos\": [\n" +
                "        {\n" +
                "            \"residentCardNo\": \"510322199705178235\",\n" +
                "            \"cardTypeCode\": \"CT/JM0001_1.01\",\n" +
                "            \"residentName\": \"测试患者\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"source\": \"PEIS\",\n" +
                "    \"idCardNo\": \"510322199705178235\",\n" +
                "    \"name\": \"测试患者\",\n" +
                "    \"telecom\": \"13200000000\",\n" +
                "    \"registerAddress\": \"测试地址\",\n" +
                "    \"currentAddress\": \"测试现住址\"\n" +
                "}," +
                "出参为{\n" +
                "\"code\": 200,\n" +
                "\"success\": true,\n" +
                "\"message\": null,\n" +
                "\"data\": {\n" +
                "\"idCardNo\": \"\",\n" +
                "\"medicalRecordNo\": \"\",\"patientId\": \"\"\n" +
                "}\n" +
                "}");


        System.out.println(result);
    }
}
