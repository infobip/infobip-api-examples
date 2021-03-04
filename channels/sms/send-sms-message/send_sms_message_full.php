<?php

$curl = curl_init();

curl_setopt_array($curl, array(
    CURLOPT_URL => 'https://%7BbaseUrl%7D/sms/2/text/advanced',
    CURLOPT_RETURNTRANSFER => true,
    CURLOPT_ENCODING => '',
    CURLOPT_MAXREDIRS => 10,
    CURLOPT_TIMEOUT => 0,
    CURLOPT_FOLLOWLOCATION => true,
    CURLOPT_HTTP_VERSION => CURL_HTTP_VERSION_1_1,
    CURLOPT_CUSTOMREQUEST => 'POST',
    CURLOPT_POSTFIELDS =>'{"messages":[{"from":"InfoSMS","destinations":[{"to":"41793026727","messageId":"MESSAGE-ID-123-xyz"},{"to":"41793026834"}],"text":"Artık Ulusal Dil Tanımlayıcısı ile Türkçe karakterli smslerinizi rahatlıkla iletebilirsiniz.","flash":false,"language":{"languageCode":"TR"},"transliteration":"TURKISH","intermediateReport":true,"notifyUrl":"https://www.example.com/sms/advanced","notifyContentType":"application/json","callbackData":"DLR callback data","validityPeriod":720},{"from":"41793026700","destinations":[{"to":"41793026700"}],"text":"A long time ago, in a galaxy far, far away... It is a period of civil war. Rebel spaceships, striking from a hidden base, have won their first victory against the evil Galactic Empire.","sendAt":"2021-08-25T16:00:00.000+0000","deliveryTimeWindow":{"from":{"hour":6,"minute":0},"to":{"hour":15,"minute":30},"days":["MONDAY","TUESDAY","WEDNESDAY","THURSDAY","FRIDAY","SATURDAY","SUNDAY"]}}],"bulkId":"BULK-ID-123-xyz","tracking":{"track":"SMS","type":"MY_CAMPAIGN"}}',
    CURLOPT_HTTPHEADER => array(
        'Authorization: {authorization}',
        'Content-Type: application/json',
        'Accept: application/json'
    ),
));

$response = curl_exec($curl);

curl_close($curl);
echo $response;

