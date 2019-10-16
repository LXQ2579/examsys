package com.damo.examsys.common;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author sanriyue
 */
@Component
@Data
public class IndexInit {
    @Autowired
    InitMsg initMsg;

    public static String CLEAR_INFO_1 = "{\n" +
            "  \"clearInfo\": {\n" +
            "    \"clearUrl\": \"";

    public static String CLEAR_INFO_2="\"\n" +
            "  },\n";

    public static String HOME_INFO_TITLE = "  \"homeInfo\": {\n" +
            "    \"title\": \"";
    public static String HOME_INFO_ICON = " \",\n" +
            "    \"icon\": \"";

    public static String HOME_INFO_HREF = " \",\n" +
            "    \"href\": \"";
    public static String HOME_INFO_END = " \"\n" +
            "  },\n";


    public static String LOGO_INFO_TITLE = "  \"logoInfo\": {\n" +
            "    \"title\": \"";
    public static String LOGO_INFO_IMAGE = "  \",\n" +
            "    \"image\": \"";
    public static String LOGO_INFO_HREF = "  \",\n" +
            "    \"href\":\"";
    public static String LOGO_INFO_END = " \"\n" +
            "  },\n";
    public static String MENU_INFO = "  \"menuInfo\":";

    public static String END = "}";



}
