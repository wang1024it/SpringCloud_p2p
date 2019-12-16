package com.wyy.common_p2p.utils;

import com.wyy.common_p2p.constant.CommonConstant;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description: jwtsession 这是从当前请求的jwt中获取数据，主要是用来获取当前的用户名和id啥的
 * @Author: cpc
 * @Date: 2019-10-30 17:28
 * @Version: V1.0
 */
public class JwtSession {
    /**
     * 获取当前jwt字符串
     * @return
     */
    private static String getCurrentJwt(){
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        return request.getHeader(CommonConstant.JWT_HEADER_KEY);
    }

    /**
     * 获取当前用户id(管理人员)
     * @return
     */
    public  static int getCurrentUserId(){
        return JwtUtils.get(getCurrentJwt(), "userId", Integer.class);
    }

    /**
     * 获取当前会员id
     * @return
     */
    public static int getCurrentMembersId(){
        return JwtUtils.get(getCurrentJwt(), "membersId", Integer.class);
    }

}
