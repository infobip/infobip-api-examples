package com.infobip.api.code.examples;

import com.infobip.ApiClient;
import com.infobip.ApiException;
import com.infobip.api.TfaApi;
import com.infobip.model.TfaLanguage;
import com.infobip.model.TfaMessage;
import com.infobip.model.TfaPinType;
import com.infobip.model.TfaUpdateMessageRequest;

public class UpdateTfaMessageTemplateLib {
    private static final String BASE_URL = System.getenv("IB_ENDPOINT_URL");
    private static final String ACCESS_TOKEN = System.getenv("IB_TOKEN");

    public static void main(String[] args) {
        ApiClient client = new ApiClient();
        client.setApiKeyPrefix("IBSSO");
        client.setApiKey(ACCESS_TOKEN);
        client.setBasePath(BASE_URL);

        try {
            TfaApi tfaApi = new TfaApi(client);
            TfaMessage template = tfaApi.updateTfaMessageTemplate("0933F3BC087D2A617AC6DCB2EF5B8A61",
                    "16A8B5FE2BCD6CA716A2D780CB3F3390",
                    new TfaUpdateMessageRequest()
                            .pinType(TfaPinType.ALPHANUMERIC)
                            .messageText("Your pin is {{pin}}")
                            .pinLength(6)
                            .language(TfaLanguage.EN)
                            .senderId("Infobip 2FA")
                            .repeatDTMF("1#")
                            .speechRate(1D)
            );
            System.out.println(template.getMessageId());
        } catch (ApiException e) {
            System.out.println(e.getCode());
            System.out.println(e.getResponseBody());
        }

    }
}
