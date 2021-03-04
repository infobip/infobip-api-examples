package com.infobip.api.code.examples;

import com.infobip.ApiClient;
import com.infobip.ApiException;
import com.infobip.api.TfaApi;
import com.infobip.model.TfaApplicationConfiguration;
import com.infobip.model.TfaApplicationRequest;
import com.infobip.model.TfaApplicationResponse;

public class CreateTfaApplicationLib {
    private static final String BASE_URL = System.getenv("IB_ENDPOINT_URL");
    private static final String ACCESS_TOKEN = System.getenv("IB_TOKEN");

    public static void main(String[] args) {
        ApiClient client = new ApiClient();
        client.setApiKeyPrefix("IBSSO");
        client.setApiKey(ACCESS_TOKEN);
        client.setBasePath(BASE_URL);

        try {
            TfaApi tfaApi = new TfaApi(client);
            TfaApplicationConfiguration config = new TfaApplicationConfiguration()
                    .pinAttempts(5)
                    .allowMultiplePinVerifications(true)
                    .pinTimeToLive("10m")
                    .verifyPinLimit("2/4s")
                    .sendPinPerApplicationLimit("5000/12h")
                    .sendPinPerPhoneNumberLimit("2/1d");
            TfaApplicationResponse response = tfaApi.createTfaApplication(new TfaApplicationRequest()
                    .name("2fa application name")
                    .enabled(true)
                    ._configuration(config)
            );
            System.out.println(response.getApplicationId());
        } catch (ApiException e) {
            System.out.println(e.getCode());
            System.out.println(e.getResponseBody());
        }

    }
}
