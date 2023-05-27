//package com.user.registration.service;
//
//import okhttp3.*;
//
//import java.io.IOException;
//
//import org.json.JSONObject;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//@Service
//public class MailService {
//    @Value("${elasticemail.api.key}")
//    private String elasticEmailApiKey;
//
//    @Value("${elasticemail.sender.email}")
//    private String senderEmail;
//
//    @Value("${elasticemail.sender.name}")
//    private String senderName;
//
//    public String sendMail(String to) {
//        // Email recipient
//        String recipient = "recipient@example.com";
//
//        // Email content
//        String subject = "Testing Elastic Email API";
//        String body = "This is a test email from Elastic Email API.";
//
//        // Elastic Email API endpoint
//        String apiUrl = "https://api.elasticemail.com/v2/email/send";
//
//        // Create JSON payload for API request
//        JSONObject requestJson = new JSONObject();
//        requestJson.put("apikey", elasticEmailApiKey);
//        requestJson.put("subject", subject);
//        requestJson.put("from", senderEmail);
//        requestJson.put("fromName", senderName);
//        requestJson.put("to", recipient);
//        requestJson.put("bodyHtml", body);
//
//        // Create OkHttp client
//        OkHttpClient client = new OkHttpClient();
//
//        // Initialize retry attempt count
//        int maxRetries = 3;
//        int retryCount = 0;
//        boolean success = false;
//
//        while (retryCount < maxRetries && !success) {
//            try {
//                // Create request and send the API request
//                MediaType mediaType = MediaType.parse("application/json");
//                RequestBody requestBody = RequestBody.create(mediaType, requestJson.toString());
//                Request request = new Request.Builder()
//                        .url(apiUrl)
//                        .post(requestBody)
//                        .build();
//
//                Response response = client.newCall(request).execute();
//
//                // Parse the response
//                String responseBody = response.body().string();
//                JSONObject responseJson = new JSONObject(responseBody);
//
//                // Get the response status
//                String status = responseJson.getString("status");
//                String message = responseJson.getString("message");
//
//                System.out.println("Response Status: " + status);
//                System.out.println("Response Message: " + message);
//
//                // Set success flag if email was sent successfully
//                if (status.equals("success")) {
//                    success = true;
//                } else {
//                    retryCount++;
//                    System.out.println("Email sending failed. Retrying attempt: " + retryCount);
//                    // Delay before retrying
//                    Thread.sleep(1000);
//                }
//            } catch (IOException | InterruptedException e) {
//                e.printStackTrace();
//                System.out.println("Something went wrong while sending the email");
//                return "Something went wrong while sending the email";
//            }
//        }
//
//        if (success) {
//            return "Email Sent Successfully";
//        } else {
//            System.out.println("Maximum number of retry attempts reached. Failed to send the email.");
//            return "Failed to send the email";
//        }
//    }
//}
//
