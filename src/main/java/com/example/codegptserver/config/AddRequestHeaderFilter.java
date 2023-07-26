package com.example.codegptserver.config;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AddRequestHeaderFilter extends ZuulFilter {
    @Value("${openai.clientId}")
    private String clientId;

    @Value("${openai.clientSecret}")
    private String clientSecret;

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        context.addZuulRequestHeader("client_id", clientId);
        context.addZuulRequestHeader("client_secret", clientSecret);
        return null;
    }
}