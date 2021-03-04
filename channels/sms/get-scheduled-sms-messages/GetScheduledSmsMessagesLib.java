package com.infobip.api.code.examples;

import com.infobip.ApiClient;
import com.infobip.ApiException;
import com.infobip.api.ScheduledSmsApi;
import com.infobip.model.SmsBulkResponse;

public class GetScheduledSmsMessagesLib {
    private static final String BASE_URL = System.getenv("IB_ENDPOINT_URL");
    private static final String ACCESS_TOKEN = System.getenv("IB_TOKEN");

    public static void main(String[] args) {
        ApiClient client = new ApiClient();
        client.setApiKeyPrefix("IBSSO");
        client.setApiKey(ACCESS_TOKEN);
        client.setBasePath(BASE_URL);

        try {
            ScheduledSmsApi api = new ScheduledSmsApi(client);
            SmsBulkResponse response = api.getScheduledSmsMessages("BULK-ID-123-xyz");
            System.out.println(response);
        } catch (ApiException e) {
            System.out.println(e.getCode());
            System.out.println(e.getResponseBody());
        }

    }
}
