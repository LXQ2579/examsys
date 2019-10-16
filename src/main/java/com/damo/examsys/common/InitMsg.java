package com.damo.examsys.common;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.awt.*;

/**
 * @author sanriyue
 */
@Component
@Data
@PropertySource(value = {"classpath:indexinit/indexinit.properties"},
        ignoreResourceNotFound = false, encoding = "UTF-8", name = "indexinit.properties")
public class InitMsg {
    @Value("${clearInfo.clearUrl}")
    private String clearUrl;

    @Value("${homeInfo.title}")
    private String homeInfoTitle;

    @Value("${homeInfo.icon}")
    private String homeInfoIcon;

    @Value("${homeInfo.href}")
    private String homeInfoHref;

    @Value("${logoInfo.title}")
    private String logoInfoTitle;
    @Value("${logoInfo.image}")
    private String logoInfoImage;
    @Value("${logoInfo.href}")
    private String logoInfoHref;
}
