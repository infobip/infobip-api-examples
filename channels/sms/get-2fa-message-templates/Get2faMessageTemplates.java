package com.infobip.api.code.examples;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class Get2faMessageTemplates {
    private static final String BASE_URL = System.getenv("IB_ENDPOINT_URL");
    private static final String ACCESS_TOKEN = String.format("IBSSO %s", System.getenv("IB_TOKEN"));

    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("https://" + BASE_URL + "/2fa/2/applications/0933F3BC087D2A617AC6DCB2EF5B8A61/messages")
                .method("GET", null)
                .addHeader("Authorization", ACCESS_TOKEN)
                .addHeader("Accept", "application/json")
                .build();
        Response response = client.newCall(request).execute();
        System.out.println(response.isSuccessful() ? "Request sent successfully." : "Failed to send request.");
        System.out.println(response.body().string());
    }
}
