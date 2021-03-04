var settings = {
    "url": "https://{baseUrl}/sms/2/text/advanced",
    "method": "POST",
    "timeout": 0,
    "headers": {
        "Authorization": "{authorization}",
        "Content-Type": "application/json",
        "Accept": "application/json"
    },
    "data": JSON.stringify({"messages":[{"from":"InfoSMS","destinations":[{"to":"41793026727"}],"text":"Toto, I've got a feeling we're not in Kansas anymore.","flash":true}]}),
};

$.ajax(settings).done(function (response) {
    console.log(response);
});