package com.infobip.api.code.examples;

import com.infobip.ApiClient;
import com.infobip.ApiException;
import com.infobip.api.SendSmsApi;
import com.infobip.model.SmsLog;
import com.infobip.model.SmsLogsResponse;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Collections;

public class GetOutboundSmsMessageLogsLib {
    private static final String BASE_URL = System.getenv("IB_ENDPOINT_URL");
    private static final String ACCESS_TOKEN = System.getenv("IB_TOKEN");

    public static void main(String[] args) {
        ApiClient client = new ApiClient();
        client.setApiKeyPrefix("IBSSO");
        client.setApiKey(ACCESS_TOKEN);
        client.setBasePath(BASE_URL);

        try {
            SendSmsApi sendSmsApi = new SendSmsApi(client);
            SmsLogsResponse logsResponse = sendSmsApi.getOutboundSmsMessageLogs(
                    null, // from
                    null, // to
                    Collections.singletonList("BULK-ID-123-xyz"), // bulkId(s)
                    null, // messageId(s)
                    null, // generalStatus
                    OffsetDateTime.of(2015, 2, 22, 17, 42, 5, 390, ZoneOffset.ofHours(1)), // sentSince
                    OffsetDateTime.of(2015, 2, 22, 19, 42, 5, 390, ZoneOffset.ofHours(1)), // sentUntil
                    null, // limit
                    null, // mcc
                    null); // mnc
            for (SmsLog log : logsResponse.getResults()) {
                System.out.println((log.getMessageId() + " - " + log.getStatus()));
            }

        } catch (ApiException e) {
            System.out.println(e.getCode());
            System.out.println(e.getResponseBody());
        }

    }
}
