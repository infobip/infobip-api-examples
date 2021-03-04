package main

import (
    "fmt"
    "strings"
    "net/http"
    "io/ioutil"
)

func main() {

    url := "https://%7BbaseUrl%7D/sms/2/text/advanced"
    method := "POST"

    payload := strings.NewReader(`{"messages":[{"from":"InfoSMS","destinations":[{"to":"41793026727"}],"text":"Ως Μεγαρικό ψήφισμα είναι γνωστή η απόφαση της Εκκλησίας του δήμου των Αθηναίων (πιθανόν γύρω στο 433/2 π.Χ.) να επιβάλει αυστηρό και καθολικό εμπάργκο στα","transliteration":"GREEK"}]}`)

    client := &http.Client {
    }
    req, err := http.NewRequest(method, url, payload)

    if err != nil {
        fmt.Println(err)
        return
    }
    req.Header.Add("Authorization", "{authorization}")
    req.Header.Add("Content-Type", "application/json")
    req.Header.Add("Accept", "application/json")

    res, err := client.Do(req)
    if err != nil {
        fmt.Println(err)
        return
    }
    defer res.Body.Close()

    body, err := ioutil.ReadAll(res.Body)
    if err != nil {
        fmt.Println(err)
        return
    }
    fmt.Println(string(body))
}