package com.infobip.api.code.examples;

import com.infobip.ApiClient;
import com.infobip.ApiException;
import com.infobip.api.TfaApi;
import com.infobip.model.TfaStartAuthenticationRequest;
import com.infobip.model.TfaStartAuthenticationResponse;

import java.util.Collections;

public class SendTfaPinCodeOverSmsLib {
    private static final String BASE_URL = System.getenv("IB_ENDPOINT_URL");
    private static final String ACCESS_TOKEN = System.getenv("IB_TOKEN");

    public static void main(String[] args) {
        ApiClient client = new ApiClient();
        client.setApiKeyPrefix("IBSSO");
        client.setApiKey(ACCESS_TOKEN);
        client.setBasePath(BASE_URL);

        try {
            TfaApi tfaApi = new TfaApi(client);
            TfaStartAuthenticationResponse response = tfaApi.sendTfaPinCodeOverSms(true, new TfaStartAuthenticationRequest()
                    .applicationId("1234567")
                    .messageId("7654321")
                    .from("Sender 1")
                    .to("41793026727")
                    .placeholders(Collections.singletonMap("firstName", "John"))
            );
            System.out.println(response.getPinId());
        } catch (ApiException e) {
            System.out.println(e.getCode());
            System.out.println(e.getResponseBody());
        }

    }
}
