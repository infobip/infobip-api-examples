package com.infobip.api.code.examples;

import com.infobip.ApiClient;
import com.infobip.ApiException;
import com.infobip.api.TfaApi;
import com.infobip.model.TfaApplicationResponse;
import com.infobip.model.TfaMessage;

import java.util.List;

public class GetTfaMessageTemplatesLib {
    private static final String BASE_URL = System.getenv("IB_ENDPOINT_URL");
    private static final String ACCESS_TOKEN = System.getenv("IB_TOKEN");

    public static void main(String[] args) {
        ApiClient client = new ApiClient();
        client.setApiKeyPrefix("IBSSO");
        client.setApiKey(ACCESS_TOKEN);
        client.setBasePath(BASE_URL);

        try {
            TfaApi tfaApi = new TfaApi(client);
            List<TfaMessage> templates = tfaApi.getTfaMessageTemplates("0933F3BC087D2A617AC6DCB2EF5B8A61");
            for (TfaMessage template : templates) {
                System.out.println(template);
            }
        } catch (ApiException e) {
            System.out.println(e.getCode());
            System.out.println(e.getResponseBody());
        }

    }
}
