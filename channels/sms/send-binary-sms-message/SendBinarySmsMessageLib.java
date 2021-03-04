package com.infobip.api.code.examples;

import com.infobip.ApiClient;
import com.infobip.ApiException;
import com.infobip.api.SendSmsApi;
import com.infobip.model.SmsAdvancedBinaryRequest;
import com.infobip.model.SmsBinaryContent;
import com.infobip.model.SmsBinaryMessage;
import com.infobip.model.SmsDeliveryTime;
import com.infobip.model.SmsDeliveryTimeWindow;
import com.infobip.model.SmsDestination;
import com.infobip.model.SmsResponse;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;

import static com.infobip.model.SmsDeliveryDay.FRIDAY;
import static com.infobip.model.SmsDeliveryDay.MONDAY;
import static com.infobip.model.SmsDeliveryDay.THURSDAY;
import static com.infobip.model.SmsDeliveryDay.WEDNESDAY;

public class SendBinarySmsMessageLib {
    private static final String BASE_URL = "https://api.infobip.com";// System.getenv("IB_ENDPOINT_URL");
    private static final String ACCESS_TOKEN = System.getenv("IB_TOKEN");

    public static void main(String[] args) {

        ApiClient client = new ApiClient();
        client.setApiKeyPrefix("IBSSO");
        client.setApiKey(ACCESS_TOKEN);
        client.setBasePath(BASE_URL);

        SendSmsApi sendSmsApi = new SendSmsApi(client);

        SmsBinaryMessage firstMessage = new SmsBinaryMessage()
                .from("InfoSMS")
                .addDestinationsItem(new SmsDestination().to("41793026727").messageId("MESSAGE-ID-123-xyz"))
                .addDestinationsItem(new SmsDestination().to("41793026834"))
                .binary(new SmsBinaryContent()
                        .hex("54 65 73 74 20 6d 65 73 73 61 67 65 2e")
                        .dataCoding(0)
                        .esmClass(0))
                .intermediateReport(true)
                .notifyUrl("https://www.example.com/sms/advanced")
                .notifyContentType("application/json")
                .callbackData("DLR callback data")
                .validityPeriod(720L);

        SmsBinaryMessage secondMessage = new SmsBinaryMessage()
                .from("41793026700")
                .addDestinationsItem(new SmsDestination().to("41793026700"))
                .binary(new SmsBinaryContent()
                        .hex("41 20 6C 6F 6E 67 20 74 69 6D 65 20 61 67 6F 2C 20 69 6E 20 61 20 67 61 6C 61 78 79 20 66 61 72 2C 20 66 61 72 20 61 77 61 79 2E 2E 2E 20 49 74 20 69 73 20 61 20 70 65 72 69 6F 64 20 6F 66 20 63 69 76 69 6C 20 77 61 72 2E 20 52 65 62 65 6C 20 73 70 61 63 65 73 68 69 70 73 2C 20 73 74 72 69 6B 69 6E 67 20 66 72 6F 6D 20 61 20 68 69 64 64 65 6E 20 62 61 73 65 2C 20 68 61 76 65 20 77 6F 6E 20 74 68 65 69 72 20 66 69 72 73 74 20 76 69 63 74 6F 72 79 20 61 67 61 69 6E 73 74 20 74 68 65 20 65 76 69 6C 20 47 61 6C 61 63 74 69 63 20 45 6D 70 69 72 65 2E")
                        .dataCoding(0)
                        .esmClass(0))
                .deliveryTimeWindow(new SmsDeliveryTimeWindow()
                        .from(new SmsDeliveryTime().hour(6).minute(0))
                        .to(new SmsDeliveryTime().hour(15).minute(30))
                        .days(Arrays.asList(MONDAY, THURSDAY, WEDNESDAY, THURSDAY, FRIDAY)))
                .sendAt(OffsetDateTime.now(ZoneOffset.ofHours(1)).plusDays(1L));

        SmsAdvancedBinaryRequest smsMessageRequest = new SmsAdvancedBinaryRequest()
                .messages(Arrays.asList(firstMessage, secondMessage))
                .bulkId("BULK-ID-123-xyz");

        try {
            SmsResponse smsResponse = sendSmsApi.sendBinarySmsMessage(smsMessageRequest);
            System.out.println(smsResponse);
        } catch (ApiException e) {
            System.out.println(String.format("Error sending message. Response code %d, body: %s", e.getCode(), e.getResponseBody()));
            e.printStackTrace();
        }

    }
}
