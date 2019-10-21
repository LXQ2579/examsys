package com.damo.examsys.common;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@Data
@PropertySource(value = {"classpath:codemsg/codemsg.properties"},
        ignoreResourceNotFound = false, encoding = "UTF-8", name = "codemsg.properties")
public class CodeMsg {
    @Value("${code.1001}")
    private String passwordEmpty;

    @Value("${code.4001}")
    private String createHtmlError;

    @Value("${code.3003}")
    private String seckillFail;

    @Value("${code.1920}")
    private String studentNull;

    @Value("${code.9001}")
    private String menuIdNull;
    @Value("${code.9002}")
    private String menuNull;

    @Value("${code.1803}")
    private String examAlready;
}
