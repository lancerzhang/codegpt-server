package com.example.codegptserver.models;

import org.springframework.boot.context.properties.NestedConfigurationProperty;

public class Model {
    private String model;
    private int contextLength;
    private String deployment;

    @NestedConfigurationProperty
    private MaxTokens maxTokens;

    @NestedConfigurationProperty
    private Session session;

    @NestedConfigurationProperty
    private RateLimit rateLimit;

    public String getDeployment() {
        return deployment;
    }

    public void setDeployment(String deployment) {
        this.deployment = deployment;
    }

    public int getContextLength() {
        return contextLength;
    }

    public void setContextLength(int contextLength) {
        this.contextLength = contextLength;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public RateLimit getRateLimit() {
        return rateLimit;
    }

    public void setRateLimit(RateLimit rateLimit) {
        this.rateLimit = rateLimit;
    }

    public MaxTokens getMaxTokens() {
        return maxTokens;
    }

    public void setMaxTokens(MaxTokens maxTokens) {
        this.maxTokens = maxTokens;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}