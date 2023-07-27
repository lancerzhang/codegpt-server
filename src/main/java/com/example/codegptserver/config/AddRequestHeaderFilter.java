package com.example.codegptserver.config;

import com.example.codegptserver.models.Model;
import com.example.codegptserver.models.RateLimit;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Bucket4j;
import io.github.bucket4j.Refill;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class AddRequestHeaderFilter extends ZuulFilter {

    private Map<String, Bucket> buckets = new ConcurrentHashMap<>();

    private OpenAIProperties openAIProperties;
    @Value("${openai.clientId}")
    private String clientId;

    @Value("${openai.clientSecret}")
    private String clientSecret;

    public AddRequestHeaderFilter(OpenAIProperties openAIProperties) {
        this.openAIProperties = openAIProperties;
        for (Model model : openAIProperties.getModels()) {
            buckets.put(model.getModel(), createNewBucket(model.getRateLimit()));
        }
    }

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

    private Bucket createNewBucket(RateLimit rateLimit) {
        return Bucket4j.builder()
                .addLimit(Bandwidth.classic(rateLimit.getRequests(),
                        Refill.greedy(rateLimit.getRequests(),
                                Duration.ofMinutes(rateLimit.getMinutes()))))
                .build();
    }

    @Override
    public Object run() throws ZuulException {
        String modelName = "gpt-35-turbo"; // replace with logic to get the model name from the request
        Bucket bucket = buckets.get(modelName);
        boolean consumed = bucket.tryConsume(1);
        if (!consumed) {
            throw new ZuulException("Rate limit exceeded for model " + modelName, 429, "Rate limit exceeded");
        }
        RequestContext context = RequestContext.getCurrentContext();
        context.addZuulRequestHeader("client_id", clientId);
        context.addZuulRequestHeader("client_secret", clientSecret);
        return null;
    }
}