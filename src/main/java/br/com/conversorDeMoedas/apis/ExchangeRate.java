package br.com.conversorDeMoedas.apis;

import br.com.conversorDeMoedas.dtos.ExchangeDTO;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeRate {
    private final String API_KEY = "1a35cfd8160c89f730b44a42";
    private final String API_URL_BASE = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/";

    public ExchangeDTO converter(String coinBase, String coinTarget, Double value) throws IOException, InterruptedException {
        var request = HttpRequest.newBuilder().uri(URI.create(
                API_URL_BASE + coinBase + "/" + coinTarget + "/" + value
        )).build();
        var response = HttpClient.newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());
        return new Gson().fromJson(response.body(), ExchangeDTO.class);
    }
}
