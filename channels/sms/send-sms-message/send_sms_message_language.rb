require "uri"
require "net/http"

url = URI("https://{baseUrl}/sms/2/text/advanced")

https = Net::HTTP.new(url.host, url.port)
https.use_ssl = true

request = Net::HTTP::Post.new(url)
request["Authorization"] = "{authorization}"
request["Content-Type"] = "application/json"
request["Accept"] = "application/json"
request.body = "{\"messages\":[{\"from\":\"InfoSMS\",\"destinations\":[{\"to\":\"41793026727\"}],\"text\":\"Artık Ulusal Dil Tanımlayıcısı ile Türkçe karakterli smslerinizi rahatlıkla iletebilirsiniz.\",\"language\":{\"languageCode\":\"TR\"}}]}"

response = https.request(request)
puts response.read_body

