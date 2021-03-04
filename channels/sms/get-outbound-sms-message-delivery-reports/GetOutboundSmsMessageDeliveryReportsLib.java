package com.infobip.api.code.examples;

import com.infobip.ApiClient;
import com.infobip.ApiException;
import com.infobip.api.SendSmsApi;
import com.infobip.model.SmsDeliveryResult;
import com.infobip.model.SmsReport;

public class GetOutboundSmsMessageDeliveryReportsLib {
    private static final String BASE_URL = System.getenv("IB_ENDPOINT_URL");
    private static final String ACCESS_TOKEN = System.getenv("IB_TOKEN");

    public static void main(String[] args) {
        ApiClient client = new ApiClient();
        client.setApiKeyPrefix("IBSSO");
        client.setApiKey(ACCESS_TOKEN);
        client.setBasePath(BASE_URL);

        try {
            SendSmsApi sendSmsApi = new SendSmsApi(client);
            SmsDeliveryResult reports = sendSmsApi.getOutboundSmsMessageDeliveryReports("BULK-ID-123-xyz", "MESSAGE-ID-123-xyz", 2);
            for (SmsReport report : reports.getResults()) {
                System.out.println((report.getMessageId() + " - " + report.getStatus()));
            }

        } catch (ApiException e) {
            System.out.println(e.getCode());
            System.out.println(e.getResponseBody());
        }

    }
}
