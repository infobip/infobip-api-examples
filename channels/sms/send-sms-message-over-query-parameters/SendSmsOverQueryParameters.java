package com.infobip.api.code.examples.send;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class SendSmsOverQueryParameters {
    private static final String BASE_URL = System.getenv("IB_ENDPOINT_URL");

    public static void main(String[] args) throws IOException {
        String userName = "insert_your_username_here";
        String password = "insert_your_password_here";

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("https://" + BASE_URL + "/sms/1/text/query" +
                        "?username=" + userName +
                        "&password=" + password +
                        "&from=InfoSMS" +
                        "&to=41793026727,41793026834" +
                        "&text=Message text" +
                        "&flash=true" +
                        "&transliteration=TURKISH" +
                        "&languageCode=TR" +
                        "&intermediateReport=true" +
                        "&notifyUrl=https://www.example.com" +
                        "&notifyContentType=application/json" +
                        "&callbackData=callbackData" +
                        "&validityPeriod=720" +
                        "&track=URL" +
                        "&trackingType=Custom tracking type")
                .method("GET", null)
                .addHeader("Accept", "application/json")
                .build();
        Response response = client.newCall(request).execute();
        System.out.println(response.isSuccessful() ? "Successfully sent SMS message." : "Failed to send SMS message.");
        System.out.println(response.body().string());
    }
}
