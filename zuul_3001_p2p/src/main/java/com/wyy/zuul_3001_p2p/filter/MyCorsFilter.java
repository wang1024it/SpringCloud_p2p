package com.wyy.zuul_3001_p2p.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MyCorsFilter extends ZuulFilter {

    /**
     * 判断该过滤器是否要被执行
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的具体执行逻辑
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest httpRequest = ctx.getRequest();
        HttpServletResponse httpResponse = ctx.getResponse();

        // Access-Control-Allow-Origin就是我们需要设置的域名
        // Access-Control-Allow-Headers跨域允许包含的头。
        // Access-Control-Allow-Methods是允许的请求方式
        httpResponse.setHeader("Access-Control-Allow-Origin", "*");// *,任何域名
        httpResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE");

        //允许客户端发送一个新的请求头
        httpResponse.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, jwt, verificationJwt");
        //允许客户端处理一个新的响应头 切记如果是多个使用 "," 隔开千万不要再setHeader以为能添加
        httpResponse.setHeader("Access-Control-Expose-Headers", "jwt,verificationJwt");
        //axios和ajax会发送两次请求，第一次提交方式为：option直接返回即可
        if("OPTIONS".equals(httpRequest.getMethod())) {
            return false;
        }
        return null;
    }

    /**
     * 过滤器的类型 这里用pre，代表会再请求被路由之前执行
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤器的执行顺序
     */
    @Override
    public int filterOrder() {
        return 0;
    }
}
