package com.ssafy.soda.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ChatGptClient {
    @Value("${openai.api-key}")
    private String apiKey;
    
    public String askGpt(String question) {
        try {
            URL url = new URL("https://api.openai.com/v1/chat/completions");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Authorization", "Bearer " + apiKey);
            conn.setRequestProperty("Content-Type", "application/json");
            
            String input = String.format(
                "{\"model\":\"gpt-3.5-turbo\",\"messages\":[{\"role\":\"user\",\"content\":\"%s\"}]}",
                question.replace("\"", "\\\"")
            );
            
            conn.setDoOutput(true);
            try(OutputStream os = conn.getOutputStream()) {
                os.write(input.getBytes("utf-8"));
            }
            
            // 에러 응답 확인
            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                System.out.println("Error response code: " + responseCode);
                return "Error: " + responseCode;
            }
            
            // 응답 읽기
            StringBuilder response = new StringBuilder();
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), "utf-8"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    response.append(line);
                    System.out.println("Response line: " + line); // 디버깅용
                }
            }
            
            String jsonResponse = response.toString();
            System.out.println("Full response: " + jsonResponse); // 디버깅용
            
            // choices[0].message.content 추출
            int contentStart = jsonResponse.indexOf("\"content\":\"") + 11;
            int contentEnd = jsonResponse.indexOf("\"", contentStart);
            
            if (contentStart >= 11 && contentEnd > contentStart) {
                return jsonResponse.substring(contentStart, contentEnd);
            }
            
            return "응답 파싱 실패";
            
        } catch(Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }
}