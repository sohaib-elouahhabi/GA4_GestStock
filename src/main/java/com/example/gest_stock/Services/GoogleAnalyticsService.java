package com.example.gest_stock.Services;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@Service
public class GoogleAnalyticsService {

    private static final String GA_TRACKING_ID = "G-1E9WXRM5EH";
    private static final String GA_COLLECT_URL = "https://www.google-analytics.com/collect";
    private final RestTemplate restTemplate; // Inject RestTemplate
    // Encode the API secret

    public GoogleAnalyticsService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
//    public void trackUserId(String userId) {
//        String measurementId = "G-1E9WXRM5EH"; // Replace with your Measurement ID
//        String apiSecret = "HyBs6Z5gQPm6iKSaYTBk2w"; // Replace with your API secret
//
//        String payload = "{\"client_id\":\"XXXXXXXXXX.YYYYYYYYYY\",\"user_properties\":[{\"name\":\"userInfo\"," +
//                "\"value\":\"" + userId + "\"}]}";
//        System.out.println("the payload is : "+ payload);
//        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
//            String encodedSecret = URLEncoder.encode(apiSecret, "UTF-8");
//
//            // Construct the URL with the encoded API secret
//            String url = "https://www.google-analytics.com/mp/collect?measurement_id=" + measurementId + "&api_secret=" + encodedSecret;
//
//            HttpPost request = new HttpPost(url);
//            request.setHeader("Content-Type", ContentType.APPLICATION_JSON.getMimeType());
//            request.setEntity(new StringEntity(payload));
//
//            HttpResponse response = httpClient.execute(request);
//
//            // Handle response as needed
//            int statusCode = response.getStatusLine().getStatusCode();
//            System.out.println("Response status code: " + statusCode);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }


//    public void trackUser(String userId, HttpServletRequest request) throws JsonProcessingException {
//        String payload = buildEventPayload(userId, request);
//
//        try {
//            HttpHeaders headers = new HttpHeaders();
//            headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
//            HttpEntity<String> entity = new HttpEntity<>(payload, headers);
//
//            ResponseEntity<String> response = restTemplate.postForEntity(GA_COLLECT_URL, entity, String.class);
//
//            if (response.getStatusCode().is2xxSuccessful()) {
//                System.out.println("Google Analytics event sent successfully");
//            } else {
//                System.out.println("Error sending event: " + response.getStatusCodeValue() + " - " + response.getBody());
//            }
//        } catch (RestClientResponseException e) {
//            System.err.println("Client-side error sending event: " + e.getMessage());
//        } catch (Exception e) {
//            System.err.println("Unexpected error sending event: " + e.getMessage());
//        }
//    }
//
//    private String buildEventPayload(String userId, HttpServletRequest request) throws JsonProcessingException {
//        Map<String, Object> eventData = new HashMap<>();
//        eventData.put("v", 1);
//        eventData.put("tid", GA_TRACKING_ID);
//        eventData.put("cid", userId);
//        eventData.put("t", "event");
//        eventData.put("ec", "Authentication");
//        eventData.put("ea", "Login");
//        eventData.put("dp", request != null ? request.getRequestURI() : "");
//        return new ObjectMapper().writeValueAsString(eventData);
//    }
}


/*
private static final String GA_TRACKING_ID = "G-1E9WXRM5EH";
    private static final String GA_COLLECT_URL = "https://www.google-analytics.com/collect";
    public static void trackUser(String userId) {
        String payload = "v=1&tid=" + GA_TRACKING_ID + "&cid=" + userId + "&t=event&ec=Authentication&ea=Login";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity<String> entity = new HttpEntity<>(payload, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(
                GA_COLLECT_URL,
                HttpMethod.POST,
                entity,
                String.class);

        HttpStatus statusCode = (HttpStatus) response.getStatusCode();
        String responseBody = response.getBody();

        System.out.println("Google Analytics Payload: " + payload);
        System.out.println("Google Analytics Response Code: " + statusCode);
        System.out.println("Google Analytics Response: " + responseBody);
    }
     */