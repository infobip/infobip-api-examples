package com.infobip.api.code.examples;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;

public class SendSmsMessageBasic {
    private static final String BASE_URL = System.getenv("IB_ENDPOINT_URL");
    private static final String ACCESS_TOKEN = String.format("IBSSO %s", System.getenv("IB_TOKEN"));

    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        String bodyJson = "{\"messages\":[{\"from\":\"InfoSMS\",\"destinations\":[{\"to\":\"41793026727\"}],\"text\":\"This is a sample message\"}]}";
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(bodyJson, mediaType);
        Request request = new Request.Builder()
                .url("https://" + BASE_URL + "/sms/2/text/advanced")
                .method("POST", body)
                .addHeader("Authorization", ACCESS_TOKEN)
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .build();
        Response response = client.newCall(request).execute();
        System.out.println(response.isSuccessful() ? "Request sent successfully." : "Failed to send request.");
        System.out.println(response.body().string());
    }
}
