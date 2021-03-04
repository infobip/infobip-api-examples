var settings = {
    "url": "https://{baseUrl}/sms/2/text/advanced",
    "method": "POST",
    "timeout": 0,
    "headers": {
        "Authorization": "{authorization}",
        "Content-Type": "application/json",
        "Accept": "application/json"
    },
    "data": JSON.stringify({"messages":[{"from":"InfoSMS","destinations":[{"to":"41793026727"}],"text":"This is a sample message"}]}),
};

$.ajax(settings).done(function (response) {
    console.log(response);
});