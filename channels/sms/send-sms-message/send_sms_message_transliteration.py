import http.client

conn = http.client.HTTPSConnection("{baseUrl}")
payload = "{\"messages\":[{\"from\":\"InfoSMS\",\"destinations\":[{\"to\":\"41793026727\"}],\"text\":\"Ως Μεγαρικό ψήφισμα είναι γνωστή η απόφαση της Εκκλησίας του δήμου των Αθηναίων (πιθανόν γύρω στο 433/2 π.Χ.) να επιβάλει αυστηρό και καθολικό εμπάργκο στα\",\"transliteration\":\"GREEK\"}]}"
headers = {
    'Authorization': '{authorization}',
    'Content-Type': 'application/json',
    'Accept': 'application/json'
}
conn.request("POST", "/sms/2/text/advanced", payload, headers)
res = conn.getresponse()
data = res.read()
print(data.decode("utf-8"))