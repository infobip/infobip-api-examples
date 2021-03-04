import http.client

conn = http.client.HTTPSConnection("{baseUrl}")
payload = "{\"messages\":[{\"from\":\"InfoSMS\",\"destinations\":[{\"to\":\"41793026727\"}],\"text\":\"Toto, I've got a feeling we're not in Kansas anymore.\",\"flash\":true}]}"
headers = {
    'Authorization': '{authorization}',
    'Content-Type': 'application/json',
    'Accept': 'application/json'
}
conn.request("POST", "/sms/2/text/advanced", payload, headers)
res = conn.getresponse()
data = res.read()
print(data.decode("utf-8"))