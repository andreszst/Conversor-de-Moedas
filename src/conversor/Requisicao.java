package conversor;

import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class Requisicao {

    public double getTaxa(String base, String alvo) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/a860957b342f47abfad84fea/latest/" + base))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();

        Gson gson = new Gson();
        Moedas moedas = gson.fromJson(json, Moedas.class);

        Map<String, Double> rates = moedas.getConversionRates();
        return rates.getOrDefault(alvo, -1.0);
    }
}