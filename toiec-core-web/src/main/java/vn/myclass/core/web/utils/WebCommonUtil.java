package vn.myclass.core.web.utils;

import org.apache.commons.lang.StringUtils;


import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class WebCommonUtil {
    public static void addRedirectMessage(HttpServletRequest request, String crudaction, Map<String, String> mapMessage){
//        if(StringUtils.isNotBlank(crudaction) && crudaction.equals(WebConstant.REDIRECT_INSERT) ){
//            request.setAttribute(WebConstant.ALERT, WebConstant.TYPE_SUCCESS );
//            request.setAttribute(WebConstant.MESSAGE_RESPONSE, mapMessage.get(WebConstant.REDIRECT_INSERT));
//        } else if (StringUtils.isNotBlank(crudaction) && crudaction.equals(WebConstant.REDIRECT_UPDATE)){
//
//        }
    }
}
