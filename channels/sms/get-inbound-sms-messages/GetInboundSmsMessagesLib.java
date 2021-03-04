package com.infobip.api.code.examples;

import com.infobip.ApiClient;
import com.infobip.ApiException;
import com.infobip.api.ReceiveSmsApi;
import com.infobip.model.SmsInboundMessage;
import com.infobip.model.SmsInboundMessageResult;

public class GetInboundSmsMessagesLib {
    private static final String BASE_URL = System.getenv("IB_ENDPOINT_URL");
    private static final String ACCESS_TOKEN = System.getenv("IB_TOKEN");

    public static void main(String[] args) {
        ApiClient client = new ApiClient();
        client.setApiKeyPrefix("IBSSO");
        client.setApiKey(ACCESS_TOKEN);
        client.setBasePath(BASE_URL);

        try {
            ReceiveSmsApi receiveSmsApi = new ReceiveSmsApi(client);
            SmsInboundMessageResult smsMessages = receiveSmsApi.getInboundSmsMessages(2);
            for (SmsInboundMessage message : smsMessages.getResults()) {
                System.out.println(message.getFrom() + " - " + message.getCleanText());
            }

        } catch (ApiException e) {
            System.out.println(e.getCode());
            System.out.println(e.getResponseBody());
        }
    }
}
