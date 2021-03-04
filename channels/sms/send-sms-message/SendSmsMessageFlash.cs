using System;
using System.Threading.Tasks;

using System.Net.Http;
using System.Net.Http.Headers;

public class SendSmsMessageFlash
{
    static async Task Main()
    {
        var client = new HttpClient();
        client.BaseAddress = new Uri("https://{baseUrl}.api.infobip.com");
        client.DefaultRequestHeaders.Authorization = new AuthenticationHeaderValue("App", "{authorization}");
        client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));
        HttpRequestMessage request = new HttpRequestMessage(HttpMethod.Post, "sms/2/text/advanced");
        request.Content = new StringContent("{\"messages\":[{\"from\":\"InfoSMS\",\"destinations\":[{\"to\":\"41793026727\"}],\"text\":\"Toto, I've got a feeling we're not in Kansas anymore.\",\"flash\":true}]}");
        var response = await client.SendAsync(request);
        var responseContent = await response.Content.ReadAsStringAsync();
        Console.WriteLine(responseContent);
    }
}