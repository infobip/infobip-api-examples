package com.infobip.api.code.examples;

import com.infobip.ApiClient;
import com.infobip.ApiException;
import com.infobip.api.TfaApi;
import com.infobip.model.TfaResendPinRequest;
import com.infobip.model.TfaStartAuthenticationResponse;
import com.infobip.model.TfaVerifyPinRequest;
import com.infobip.model.TfaVerifyPinResponse;

import java.util.Collections;

public class VerifyPhoneNumberLib {
    private static final String BASE_URL = System.getenv("IB_ENDPOINT_URL");
    private static final String ACCESS_TOKEN = System.getenv("IB_TOKEN");

    public static void main(String[] args) {
        ApiClient client = new ApiClient();
        client.setApiKeyPrefix("IBSSO");
        client.setApiKey(ACCESS_TOKEN);
        client.setBasePath(BASE_URL);

        try {
            TfaApi tfaApi = new TfaApi(client);
            TfaVerifyPinResponse response = tfaApi.verifyTfaPhoneNumber(
                    "9C817C6F8AF3D48F9FE553282AFA2B67",
                    new TfaVerifyPinRequest().pin("1234"));
            System.out.println(response.getVerified());
        } catch (ApiException e) {
            System.out.println(e.getCode());
            System.out.println(e.getResponseBody());
        }

    }
}
