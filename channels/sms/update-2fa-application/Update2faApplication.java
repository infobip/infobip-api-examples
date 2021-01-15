package com.infobip.api.code.examples;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;

public class Update2faApplication {
    private static final String BASE_URL = System.getenv("IB_ENDPOINT_URL");
    private static final String ACCESS_TOKEN = String.format("IBSSO %s", System.getenv("IB_TOKEN"));

    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create("{\"name\":\"2fa application name\",\"enabled\":true,\"configuration\":{\"pinAttempts\":5,\"allowMultiplePinVerifications\":true,\"pinTimeToLive\":\"10m\",\"verifyPinLimit\":\"2/4s\",\"sendPinPerApplicationLimit\":\"5000/12h\",\"sendPinPerPhoneNumberLimit\":\"2/1d\"}}", mediaType);
        Request request = new Request.Builder()
                .url("https://" + BASE_URL + "/2fa/2/applications/0933F3BC087D2A617AC6DCB2EF5B8A61")
                .method("PUT", body)
                .addHeader("Authorization", ACCESS_TOKEN)
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .build();
        Response response = client.newCall(request).execute();
        System.out.println(response.isSuccessful() ? "Request sent successfully." : "Failed to send request.");
        System.out.println(response.body().string());
    }
}
