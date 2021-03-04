package com.infobip.api.code.examples;

import com.infobip.ApiClient;
import com.infobip.ApiException;
import com.infobip.api.TfaApi;
import com.infobip.model.TfaApplicationResponse;

import java.util.List;

public class GetTfaApplicationsLib {
    private static final String BASE_URL = System.getenv("IB_ENDPOINT_URL");
    private static final String ACCESS_TOKEN = System.getenv("IB_TOKEN");

    public static void main(String[] args) {
        ApiClient client = new ApiClient();
        client.setApiKeyPrefix("IBSSO");
        client.setApiKey(ACCESS_TOKEN);
        client.setBasePath(BASE_URL);

        try {
            TfaApi tfaApi = new TfaApi(client);
            List<TfaApplicationResponse> applications = tfaApi.getTfaApplications();
            for (TfaApplicationResponse app : applications) {
                System.out.println(app);
            }
        } catch (ApiException e) {
            System.out.println(e.getCode());
            System.out.println(e.getResponseBody());
        }

    }
}
