require "uri"
require "net/http"

url = URI("https://{baseUrl}/sms/2/text/advanced")

https = Net::HTTP.new(url.host, url.port)
https.use_ssl = true

request = Net::HTTP::Post.new(url)
request["Authorization"] = "{authorization}"
request["Content-Type"] = "application/json"
request["Accept"] = "application/json"
request.body = "{\"messages\":[{\"from\":\"InfoSMS\",\"destinations\":[{\"to\":\"41793026727\"}],\"text\":\"Ως Μεγαρικό ψήφισμα είναι γνωστή η απόφαση της Εκκλησίας του δήμου των Αθηναίων (πιθανόν γύρω στο 433/2 π.Χ.) να επιβάλει αυστηρό και καθολικό εμπάργκο στα\",\"transliteration\":\"GREEK\"}]}"

response = https.request(request)
puts response.read_body

