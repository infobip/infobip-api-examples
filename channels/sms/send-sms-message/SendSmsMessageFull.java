package com.infobip.api.code.examples;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;

public class SendSmsMessageFull {
    private static final String BASE_URL = System.getenv("IB_ENDPOINT_URL");
    private static final String ACCESS_TOKEN = String.format("IBSSO %s", System.getenv("IB_TOKEN"));

    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        String bodyJson = "{\"messages\":[{\"from\":\"InfoSMS\",\"destinations\":[{\"to\":\"41793026727\",\"messageId\":\"MESSAGE-ID-123-xyz\"},{\"to\":\"41793026834\"}],\"text\":\"Artık Ulusal Dil Tanımlayıcısı ile Türkçe karakterli smslerinizi rahatlıkla iletebilirsiniz.\",\"flash\":false,\"language\":{\"languageCode\":\"TR\"},\"transliteration\":\"TURKISH\",\"intermediateReport\":true,\"notifyUrl\":\"https://www.example.com/sms/advanced\",\"notifyContentType\":\"application/json\",\"callbackData\":\"DLR callback data\",\"validityPeriod\":720},{\"from\":\"41793026700\",\"destinations\":[{\"to\":\"41793026700\"}],\"text\":\"A long time ago, in a galaxy far, far away... It is a period of civil war. Rebel spaceships, striking from a hidden base, have won their first victory against the evil Galactic Empire.\",\"sendAt\":\"2021-08-25T16:00:00.000+0000\",\"deliveryTimeWindow\":{\"from\":{\"hour\":6,\"minute\":0},\"to\":{\"hour\":15,\"minute\":30},\"days\":[\"MONDAY\",\"TUESDAY\",\"WEDNESDAY\",\"THURSDAY\",\"FRIDAY\",\"SATURDAY\",\"SUNDAY\"]}}],\"bulkId\":\"BULK-ID-123-xyz\",\"tracking\":{\"track\":\"SMS\",\"type\":\"MY_CAMPAIGN\"}}";
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
