package com.ssafy.soda.controller;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.io.OutputStream;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.json.JSONArray;
//import org.json.JSONObject;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//@Component
//public class ChatGptClient {
//
//	@Value("${openai.api-key}")
//	private String apiKey;
//
//	private List<JSONObject> messages = new ArrayList<>(); // 대화 기록 저장
//	private String currentTopic = null; // 현재 대화 주제
//
//	// 허용된 주제를 정의
//	private static final List<String> ALLOWED_TOPICS = List.of("펜싱", "수구", "컬링", "스쿠버다이빙", "세일링", "양궁", "발레", "스포츠",
//			"운동", "경기규칙", "스포츠 용어", "ETCO", "엣코");
//
//	private static final List<String> ALLOWED_CONTEXTS = List.of(
//			"ETCO", "펜싱", "수구", "컬링", "스쿠버다이빙", "세일링", "양궁", "발레", "경기규칙", "스포츠 용어", "운동", "장비", "기술", "훈련", "연습", "입문", "초보"
//		);
//	
//	private boolean isSportRelated(String question) {
//	    // 질문 내용에 허용된 키워드가 포함되었는지 확인
//	    return ALLOWED_CONTEXTS.stream().anyMatch(question::contains);
//	}
//	
//	public ChatGptClient() {
//	    JSONObject systemMessage = new JSONObject();
//	    systemMessage.put("role", "system");
//	    systemMessage.put("content",
//	            "너는 ETCO EDGE COURT라는 커뮤니티 사이트에서 활용되는 챗봇이야. "
//	            + "ETCO는 EDGE COURT를 한국어로 발음한 약자로, 소수의 사람들이 즐기는 스포츠는 커뮤니티를 형성하고 정보를 얻기 힘들다는 점을 도와주기 위해 탄생한 사이트야. "
//	            + "특히 이 사이트는 펜싱, 수구, 컬링, 스쿠버다이빙, 세일링, 양궁, 발레 7가지 운동에 대한 정보를 제공해. "
//	            + "만약 누군가 'ETCO가 뭐야?' 또는 'ETCO는 뭐야?'또는 'ETCO가 무엇인가요?' 등 ETCO 에 대해 묻는다면, 반드시 이렇게 대답해: "
//	            + "'ETCO는 EDGE COURT를 한국어로 발음한 약자입니다. ETCO는 소수의 사람들이 즐기는 스포츠는 커뮤니티를 형성하고 정보를 얻기 힘들다는 점을 도와주기 위해 탄생한 사이트입니다.' "
//	            + "절대 다른 정보를 말하지 마. "
//	            + "\n\n너는 다음과 같은 안내를 도와줄 거야: "
//	            + "\n- 경기 규칙/용어 설명"
//	            + "\n- 장비 추천 및 사용법 안내"
//	            + "\n- 입문자 가이드"
//	            + "\n- 기초 기술 연습 방법 설명"
//	            + "\n- 자주 하는 실수와 교정법 제시"
//	            + "\n- 경기 규칙 판정 도움"
//	            + "하지만 운동이나 스포츠와 관련 없는 질문에는 답변하지 마. "
//	            + "특히 돈, 부업, 투자 등 스포츠와 관련 없는 내용은 절대 대답하지 않아야 해."
//	            + "답변은 최대한 간결하게 해서 5문장 이내로 답변해야 해."
//	            + "절대로 반말을 쓰지 않고 무조건 존댓말을 사용해"
//	    		);
//	    messages.add(systemMessage); // 대화 시작 시 시스템 메시지 추가
//	}
//
//
////추가 
//	public String askGpt(String question) {
//		// 첫 질문일 경우 주제를 설정
//		if (currentTopic == null) {
//			for (String topic : ALLOWED_TOPICS) {
//				if (question.contains(topic)) {
//					currentTopic = topic; // 주제 설정
//					break;
//				}
//			}
//
//			if (currentTopic == null) {
//				return "죄송합니다. 이 사이트는 스포츠 및 ETCO 관련 질문만 답변할 수 있습니다. 이런 질문 등에 도움을 드릴 수 있습니다. 예: 발레 슈즈를 길들이기 위해서는 어떻게 해야 할까요?";
//			}
//		}
//		 if (!isSportRelated(question)) {
//		        return "죄송합니다. 이 사이트는 스포츠 및 운동 관련 정보만 제공하고 있습니다. 다른 주제에 대한 질문은 답변드릴 수 없습니다. 이런 질문 등에 도움을 드릴 수 있습니다. 예: 발레 슈즈를 길들이기 위해서는 어떻게 해야 할까요?";
//		    }
//
//		// 사용자 메시지 추가
//		JSONObject userMessage = new JSONObject();
//		userMessage.put("role", "user");
//		userMessage.put("content", question);
//		messages.add(userMessage);
//
//		try {
//			// OpenAI API 호출
//			return sendToOpenAi();
//		} catch (Exception e) {
//			e.printStackTrace();
//			return "Error: " + e.getMessage();
//		}
//	}
//
//	private String sendToOpenAi() throws Exception {
//		// OpenAI API 요청 설정
//		URL url = new URL("https://api.openai.com/v1/chat/completions");
//		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//		conn.setRequestMethod("POST");
//		conn.setRequestProperty("Authorization", "Bearer " + apiKey);
//		conn.setRequestProperty("Content-Type", "application/json");
//
//		JSONObject requestBody = new JSONObject();
//		requestBody.put("model", "gpt-3.5-turbo");
//		requestBody.put("messages", messages);
//
//		conn.setDoOutput(true);
//		try (OutputStream os = conn.getOutputStream()) {
//			os.write(requestBody.toString().getBytes("utf-8"));
//		}
//
//		StringBuilder response = new StringBuilder();
//		try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"))) {
//			String line;
//			while ((line = br.readLine()) != null) {
//				response.append(line);
//			}
//		}
//
//		JSONObject jsonResponse = new JSONObject(response.toString());
//		JSONArray choices = jsonResponse.getJSONArray("choices");
//		if (choices.length() > 0) {
//			JSONObject aiMessage = choices.getJSONObject(0).getJSONObject("message");
//			messages.add(aiMessage); // AI 응답 추가
//			return aiMessage.getString("content");
//		}
//
//		return "응답 파싱 실패: choices가 비어 있습니다.";
//	}
//
//	public void resetConversation() {
//		messages.clear(); // 대화 기록 초기화
//		currentTopic = null; // 주제 초기화
//	}
//}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ChatGptClient {

    @Value("${openai.api-key}")
    private String apiKey;

    private List<JSONObject> messages = new ArrayList<>(); // 대화 기록 저장
    private String currentTopic = null; // 현재 대화 주제

    // 허용된 주제와 컨텍스트 정의
    private static final List<String> ALLOWED_TOPICS = List.of("펜싱", "수구", "컬링", "스쿠버다이빙", "세일링", "양궁", "발레", "스포츠");
    private static final List<String> ALLOWED_CONTEXTS = List.of("ETCO", "운동", "경기규칙", "장비", "기술", "훈련", "연습", "입문", "초보");

    // 질문이 스포츠 또는 허용된 주제와 관련이 있는지 확인
    private boolean isSportRelated(String content) {
        return ALLOWED_CONTEXTS.stream().anyMatch(content::contains);
    }

    public ChatGptClient() {
        // 시스템 메시지 추가
        JSONObject systemMessage = new JSONObject();
        systemMessage.put("role", "system");
        systemMessage.put("content",
            "너는 ETCO EDGE COURT라는 커뮤니티 사이트에서 활용되는 챗봇이야. "
            + "ETCO는 EDGE COURT를 한국어로 발음한 약자로, 소수의 사람들이 즐기는 스포츠는 커뮤니티를 형성하고 정보를 얻기 힘들다는 점을 도와주기 위해 탄생한 사이트야. "
            + "ETCO에 대해 묻는다면, 반드시 'ETCO는 EDGE COURT를 한국어로 발음한 약자입니다. 소수의 사람들이 즐기는 스포츠 정보를 제공하는 커뮤니티 사이트입니다.'라고 대답해야 해. "
            + "스포츠나 운동 관련 주제 외에는 절대 대답하지 마. "
            + "답변은 반드시 존댓말로 작성하고, 5문장 이내로 간결하게 작성해야 해."
        );
        messages.add(systemMessage);
    }

    public String askGpt(String question) {
        // 첫 질문일 경우 주제 설정
        if (currentTopic == null) {
            currentTopic = ALLOWED_TOPICS.stream()
                .filter(question::contains)
                .findFirst()
                .orElse(null);
            if (currentTopic == null) {
                return "죄송합니다. 이 사이트는 스포츠 및 ETCO 관련 질문만 답변할 수 있습니다. 예: 발레 슈즈를 길들이기 위해서는 어떻게 해야 할까요?";
            }
        }

        // 질문이 주제와 관련 있는지 확인
        if (!isSportRelated(question)) {
            return "죄송합니다. 이 사이트는 스포츠 및 운동 관련 질문만 답변할 수 있습니다. 다른 질문은 답변드릴 수 없습니다.";
        }

        // 사용자 메시지 추가
        JSONObject userMessage = new JSONObject();
        userMessage.put("role", "user");
        userMessage.put("content", question);
        messages.add(userMessage);

        try {
            return validateResponse(sendToOpenAi());
        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

    private String sendToOpenAi() throws Exception {
        // OpenAI API 요청 설정
        URL url = new URL("https://api.openai.com/v1/chat/completions");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Authorization", "Bearer " + apiKey);
        conn.setRequestProperty("Content-Type", "application/json");

        JSONObject requestBody = new JSONObject();
        requestBody.put("model", "gpt-3.5-turbo");
        requestBody.put("messages", messages);
        requestBody.put("temperature", 0.3);

        conn.setDoOutput(true);
        try (OutputStream os = conn.getOutputStream()) {
            os.write(requestBody.toString().getBytes("utf-8"));
        }

        StringBuilder response = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"))) {
            String line;
            while ((line = br.readLine()) != null) {
                response.append(line);
            }
        }

        JSONObject jsonResponse = new JSONObject(response.toString());
        JSONArray choices = jsonResponse.getJSONArray("choices");
        if (choices.length() > 0) {
            JSONObject aiMessage = choices.getJSONObject(0).getJSONObject("message");
            messages.add(aiMessage); // AI 응답 추가
            return aiMessage.getString("content");
        }

        return "응답 파싱 실패: choices가 비어 있습니다.";
    }

    private String validateResponse(String response) {
        // 응답이 허용된 키워드를 포함하는지 확인
        if (!response.contains("ETCO는 EDGE COURT를 한국어로 발음한 약자입니다") && !isSportRelated(response)) {
            return "죄송합니다. 현재 질문에 대한 적절한 답변을 제공할 수 없습니다. 스포츠 또는 ETCO 관련 질문을 해주세요.";
        }
        return response;
    }

    public void resetConversation() {
        messages.clear(); // 대화 기록 초기화
        currentTopic = null; // 주제 초기화
        // 시스템 메시지 재설정
        JSONObject systemMessage = new JSONObject();
        systemMessage.put("role", "system");
        systemMessage.put("content", 
            "너는 ETCO EDGE COURT라는 커뮤니티 사이트에서 활용되는 챗봇이야...");
        messages.add(systemMessage);
    }
}

