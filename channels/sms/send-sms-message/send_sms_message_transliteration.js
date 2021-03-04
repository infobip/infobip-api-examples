var settings = {
    "url": "https://{baseUrl}/sms/2/text/advanced",
    "method": "POST",
    "timeout": 0,
    "headers": {
        "Authorization": "{authorization}",
        "Content-Type": "application/json",
        "Accept": "application/json"
    },
    "data": JSON.stringify({"messages":[{"from":"InfoSMS","destinations":[{"to":"41793026727"}],"text":"Ως Μεγαρικό ψήφισμα είναι γνωστή η απόφαση της Εκκλησίας του δήμου των Αθηναίων (πιθανόν γύρω στο 433/2 π.Χ.) να επιβάλει αυστηρό και καθολικό εμπάργκο στα","transliteration":"GREEK"}]}),
};

$.ajax(settings).done(function (response) {
    console.log(response);
});