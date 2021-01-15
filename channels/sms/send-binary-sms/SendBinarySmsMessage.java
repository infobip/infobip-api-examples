package com.infobip.api.code.examples;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;

public class SendBinarySmsMessage {
    private static final String BASE_URL = System.getenv("IB_ENDPOINT_URL");
    private static final String ACCESS_TOKEN = String.format("IBSSO %s", System.getenv("IB_TOKEN"));

    public static void main(String[] args) throws IOException {

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        String bodyJson = "{\"messages\":[{\"from\":\"InfoSMS\",\"destinations\":[{\"to\":\"41793026727\",\"messageId\":\"MESSAGE-ID-123-xyz\"},{\"to\":\"41793026834\"}],\"binary\":{\"hex\":\"54 65 73 74 20 6d 65 73 73 61 67 65 2e\",\"dataCoding\":0,\"esmClass\":0},\"intermediateReport\":true,\"notifyUrl\":\"https://www.example.com/sms/advanced\",\"notifyContentType\":\"application/json\",\"callbackData\":\"DLR callback data\",\"validityPeriod\":720},{\"from\":\"41793026700\",\"destinations\":[{\"to\":\"41793026700\"}],\"binary\":{\"hex\":\"41 20 6C 6F 6E 67 20 74 69 6D 65 20 61 67 6F 2C 20 69 6E 20 61 20 67 61 6C 61 78 79 20 66 61 72 2C 20 66 61 72 20 61 77 61 79 2E 2E 2E 20 49 74 20 69 73 20 61 20 70 65 72 69 6F 64 20 6F 66 20 63 69 76 69 6C 20 77 61 72 2E 20 52 65 62 65 6C 20 73 70 61 63 65 73 68 69 70 73 2C 20 73 74 72 69 6B 69 6E 67 20 66 72 6F 6D 20 61 20 68 69 64 64 65 6E 20 62 61 73 65 2C 20 68 61 76 65 20 77 6F 6E 20 74 68 65 69 72 20 66 69 72 73 74 20 76 69 63 74 6F 72 79 20 61 67 61 69 6E 73 74 20 74 68 65 20 65 76 69 6C 20 47 61 6C 61 63 74 69 63 20 45 6D 70 69 72 65 2E\",\"dataCoding\":0,\"esmClass\":0},\"sendAt\":\"2021-08-25T16:00:00.000+0000\",\"deliveryTimeWindow\":{\"from\":{\"hour\":6,\"minute\":0},\"to\":{\"hour\":15,\"minute\":30},\"days\":[\"MONDAY\",\"TUESDAY\",\"WEDNESDAY\",\"THURSDAY\",\"FRIDAY\",\"SATURDAY\",\"SUNDAY\"]}}],\"bulkId\":\"BULK-ID-123-xyz\",\"tracking\":{\"track\":\"SMS\",\"type\":\"MY_CAMPAIGN\"}}";
        RequestBody body = RequestBody.create(bodyJson, mediaType);
        Request request = new Request.Builder()
                .url("https://" + BASE_URL + "/sms/2/binary/advanced")
                .method("POST", body)
                .addHeader("Authorization", ACCESS_TOKEN)
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .build();
        Response response = client.newCall(request).execute();
        System.out.println(response.isSuccessful() ? "Successfully sent SMS message." : "Failed to send SMS message.");
        System.out.println(response.body().string());
    }
}
