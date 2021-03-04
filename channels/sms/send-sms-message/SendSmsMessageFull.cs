using System;
using System.Threading.Tasks;

using System.Net.Http;
using System.Net.Http.Headers;

public class SendSmsMessageFull
{
    static async Task Main()
    {
        var client = new HttpClient();
        client.BaseAddress = new Uri("https://{baseUrl}.api.infobip.com");
        client.DefaultRequestHeaders.Authorization = new AuthenticationHeaderValue("App", "{authorization}");
        client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));
        HttpRequestMessage request = new HttpRequestMessage(HttpMethod.Post, "sms/2/text/advanced");
        request.Content = new StringContent("{\"messages\":[{\"from\":\"InfoSMS\",\"destinations\":[{\"to\":\"41793026727\",\"messageId\":\"MESSAGE-ID-123-xyz\"},{\"to\":\"41793026834\"}],\"text\":\"Artık Ulusal Dil Tanımlayıcısı ile Türkçe karakterli smslerinizi rahatlıkla iletebilirsiniz.\",\"flash\":false,\"language\":{\"languageCode\":\"TR\"},\"transliteration\":\"TURKISH\",\"intermediateReport\":true,\"notifyUrl\":\"https://www.example.com/sms/advanced\",\"notifyContentType\":\"application/json\",\"callbackData\":\"DLR callback data\",\"validityPeriod\":720},{\"from\":\"41793026700\",\"destinations\":[{\"to\":\"41793026700\"}],\"text\":\"A long time ago, in a galaxy far, far away... It is a period of civil war. Rebel spaceships, striking from a hidden base, have won their first victory against the evil Galactic Empire.\",\"sendAt\":\"2021-08-25T16:00:00.000+0000\",\"deliveryTimeWindow\":{\"from\":{\"hour\":6,\"minute\":0},\"to\":{\"hour\":15,\"minute\":30},\"days\":[\"MONDAY\",\"TUESDAY\",\"WEDNESDAY\",\"THURSDAY\",\"FRIDAY\",\"SATURDAY\",\"SUNDAY\"]}}],\"bulkId\":\"BULK-ID-123-xyz\",\"tracking\":{\"track\":\"SMS\",\"type\":\"MY_CAMPAIGN\"}}");
        var response = await client.SendAsync(request);
        var responseContent = await response.Content.ReadAsStringAsync();
        Console.WriteLine(responseContent);
    }
}