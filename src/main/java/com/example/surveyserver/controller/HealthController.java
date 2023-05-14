package com.example.surveyserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/api/v1/.well-known/health")
    public String health() {
        return "OK";
    }

    @PostMapping("/api/v1/chat/completions")
    public String chatCompletions() {
        return "{\n" +
                "    \"msg\": \"success to trigger the API\",\n" +
                "    \"code\": \"00000\",\n" +
                "    \"data\": {\n" +
                "        \"id\": \"chatcmpl-7FMw5nBSebsOcz0DflieR4kGC62Rj\",\n" +
                "        \"object\": \"chat.completion\",\n" +
                "        \"created\": 1.683897441E9,\n" +
                "        \"model\": \"gpt-35-turbo\",\n" +
                "        \"choices\": [\n" +
                "            {\n" +
                "                \"index\": 0.0,\n" +
                "                \"finish_reason\": \"stop\",\n" +
                "                \"message\": {\n" +
                "                    \"role\": \"assistant\",\n" +
                "                    \"content\": \"Sure, here's an example Java code for summing up an array:\\n\\n```\\npublic class SumArray {\\n public static void main(String[] args) {\\n int[] arr = {1, 2, 3, 4, 5};\\n int sum = 0;\\n \\n for (int i = 0; i < arr.length; i++) {\\n sum += arr[i];\\n }\\n \\n System.out.println(\\\"The sum of the array is: \\\" + sum);\\n }\\n}\\n```\\n\\nIn this code, we first declare an integer array `arr` with some values. We then declare an integer variable `sum` and initialize it to 0.\\n\\nWe then use a `for` loop to iterate through each element of the array and add it to the `sum` variable. Finally, we print out the sum of the array using `System.out.println()`.\"\n" +
                "                }\n" +
                "            }\n" +
                "        ],\n" +
                "        \"usage\": {\n" +
                "            \"completion_tokens\": 183.0,\n" +
                "            \"prompt_tokens\": 25.0,\n" +
                "            \"total_tokens\": 208.0\n" +
                "        }\n" +
                "    },\n" +
                "    \"timestamp\": 1683897447785,\n" +
                "    \"requestId\": \"72ae5d90-d0c1-4342-9394-b1ea5beda43f\"\n" +
                "}";
    }

}