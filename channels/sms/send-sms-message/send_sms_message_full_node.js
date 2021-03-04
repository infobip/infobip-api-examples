var https = require('follow-redirects').https;
var fs = require('fs');

var options = {
    'method': 'POST',
    'hostname': '{baseUrl}',
    'path': '/sms/2/text/advanced',
    'headers': {
        'Authorization': '{authorization}',
        'Content-Type': 'application/json',
        'Accept': 'application/json'
    },
    'maxRedirects': 20
};

var req = https.request(options, function (res) {
    var chunks = [];

    res.on("data", function (chunk) {
        chunks.push(chunk);
    });

    res.on("end", function (chunk) {
        var body = Buffer.concat(chunks);
        console.log(body.toString());
    });

    res.on("error", function (error) {
        console.error(error);
    });
});

var postData = JSON.stringify({"messages":[{"from":"InfoSMS","destinations":[{"to":"41793026727","messageId":"MESSAGE-ID-123-xyz"},{"to":"41793026834"}],"text":"Artık Ulusal Dil Tanımlayıcısı ile Türkçe karakterli smslerinizi rahatlıkla iletebilirsiniz.","flash":false,"language":{"languageCode":"TR"},"transliteration":"TURKISH","intermediateReport":true,"notifyUrl":"https://www.example.com/sms/advanced","notifyContentType":"application/json","callbackData":"DLR callback data","validityPeriod":720},{"from":"41793026700","destinations":[{"to":"41793026700"}],"text":"A long time ago, in a galaxy far, far away... It is a period of civil war. Rebel spaceships, striking from a hidden base, have won their first victory against the evil Galactic Empire.","sendAt":"2021-08-25T16:00:00.000+0000","deliveryTimeWindow":{"from":{"hour":6,"minute":0},"to":{"hour":15,"minute":30},"days":["MONDAY","TUESDAY","WEDNESDAY","THURSDAY","FRIDAY","SATURDAY","SUNDAY"]}}],"bulkId":"BULK-ID-123-xyz","tracking":{"track":"SMS","type":"MY_CAMPAIGN"}});

req.write(postData);

req.end();