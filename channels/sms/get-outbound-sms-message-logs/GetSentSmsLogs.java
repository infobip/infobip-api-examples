package com.infobip.api.code.examples;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class GetSentSmsLogs {
    private static final String BASE_URL = System.getenv("IB_ENDPOINT_URL");
    private static final String ACCESS_TOKEN = String.format("IBSSO %s", System.getenv("IB_TOKEN"));

    public static void main(String[] args) throws IOException {

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("https://" + BASE_URL + "sms/1/logs?bulkId=BULK-ID-123-xyz&sentSince=2015-02-22T17:42:05.390+01:00")
                .method("GET", null)
                .addHeader("Authorization", ACCESS_TOKEN)
                .addHeader("Accept", "application/json")
                .build();
        Response response = client.newCall(request).execute();
        System.out.println(response.isSuccessful() ? "Request sent successfully." : "Failed to send request.");
        System.out.println(response.body().string());
    }
}
