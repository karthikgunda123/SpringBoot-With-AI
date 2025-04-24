package gunda.karthik.spring.ai.gemini_chatbot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Service
public class QnAService
{
    // Access to API key and URL [Gemini]
    @Value("${gemini.api.url}")
    private String geminiAPIURL;

    @Value("${gemini.api.key}")
    private String geminiAPIKey;

    private final WebClient webClient;

    public QnAService(WebClient.Builder webClient)
    {
        this.webClient = webClient.build();
    }

    public String getAnswer(String question)
    {
        // construct the request payload
        Map<String, Object> requestBody = Map.of(
                "contents", new Object[] {
                        Map.of("parts", new Object[] {
                                Map.of("text", question)
                        })
                }
        );

        // Make API call
        String response = webClient.post()
                .uri(geminiAPIURL + geminiAPIKey)
                .header("Content-Type", "application/json")
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        // return response
        return response;
    }
}