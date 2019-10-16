package com.damo.examsys.utils;

import com.damo.examsys.common.IndexInit;
import com.damo.examsys.common.InitMsg;
import com.damo.examsys.entity.MenuModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author sanriyue
 */
@Component
public class IndexInitUtils {
    @Autowired
    InitMsg initMsg;

    public String indexInit(String rootMenu){
        String clear = IndexInit.CLEAR_INFO_1 + initMsg.getClearUrl() +IndexInit. CLEAR_INFO_2;
        String home = IndexInit.HOME_INFO_TITLE + initMsg.getHomeInfoTitle() +
                IndexInit. HOME_INFO_ICON + initMsg.getHomeInfoIcon()+
                IndexInit. HOME_INFO_HREF + initMsg.getHomeInfoHref() +
                IndexInit.HOME_INFO_END ;
        String logo = IndexInit.LOGO_INFO_TITLE + initMsg.getLogoInfoTitle() +
                IndexInit.LOGO_INFO_IMAGE + initMsg.getLogoInfoImage() +
                IndexInit.LOGO_INFO_HREF + initMsg.getLogoInfoHref() + IndexInit.LOGO_INFO_END;

        return clear + home + logo +IndexInit.MENU_INFO+rootMenu+IndexInit.END;
    }
}
