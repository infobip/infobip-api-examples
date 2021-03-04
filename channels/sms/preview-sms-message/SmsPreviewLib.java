package com.infobip.api.code.examples;

import com.infobip.ApiClient;
import com.infobip.ApiException;
import com.infobip.Configuration;
import com.infobip.api.SendSmsApi;
import com.infobip.model.SmsPreviewRequest;
import com.infobip.model.SmsPreviewResponse;

public class SmsPreviewLib {
    private static final String BASE_URL = System.getenv("IB_ENDPOINT_URL");
    private static final String ACCESS_TOKEN = System.getenv("IB_TOKEN");

    public static void main(String[] args) {
        ApiClient client = new ApiClient();
        client.setApiKeyPrefix("IBSSO");
        client.setApiKey(ACCESS_TOKEN);
        client.setBasePath(BASE_URL);

        try {
            SendSmsApi sendSmsApi = new SendSmsApi(client);
            SmsPreviewResponse previewResponse = sendSmsApi.previewSmsMessage(new SmsPreviewRequest()
                    .text("Let's see how many characters will remain unused in this message.")
            );
            System.out.println(previewResponse);
        } catch (ApiException e) {
            System.out.println(e.getCode());
            System.out.println(e.getResponseBody());
        }

    }
}
