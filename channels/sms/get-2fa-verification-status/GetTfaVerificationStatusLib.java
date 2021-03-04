package com.infobip.api.code.examples;

import com.infobip.ApiClient;
import com.infobip.ApiException;
import com.infobip.api.TfaApi;
import com.infobip.model.TfaVerification;
import com.infobip.model.TfaVerificationResponse;

public class GetTfaVerificationStatusLib {
    private static final String BASE_URL = System.getenv("IB_ENDPOINT_URL");
    private static final String ACCESS_TOKEN = System.getenv("IB_TOKEN");

    public static void main(String[] args) {
        ApiClient client = new ApiClient();
        client.setApiKeyPrefix("IBSSO");
        client.setApiKey(ACCESS_TOKEN);
        client.setBasePath(BASE_URL);

        try {
            TfaApi tfaApi = new TfaApi(client);
            TfaVerificationResponse response = tfaApi.getTfaVerificationStatus(
                    "385717284759547",
                    "16A8B5FE2BCD6CA716A2D780CB3F3390",
                    false,
                    true
            );
            for (TfaVerification verification : response.getVerifications()) {
                System.out.println(verification);
            }
        } catch (ApiException e) {
            System.out.println(e.getCode());
            System.out.println(e.getResponseBody());
        }

    }
}
