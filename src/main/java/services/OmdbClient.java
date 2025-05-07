package services;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class OmdbClient {
    private final String JSON_RESPONSE;

    public OmdbClient(String title, String API_KEY) throws IOException, InterruptedException {

        // codifica o título para evitar caracteres inválidos na URL (espaços em branco e etc)
        String encodedTitle = URLEncoder.encode(title, StandardCharsets.UTF_8);

        // instanciando cliente http
        HttpClient client = HttpClient.newHttpClient();

        // request para a API
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://www.omdbapi.com/?t="+encodedTitle+"&apikey="+API_KEY))
                .build();
        // capturando a resposta da API
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        // armazenando a resposta
        this.JSON_RESPONSE = response.body();
    }

    public String getResponse() {
        return JSON_RESPONSE;
    }
}
