package dk.keadat21v2.movieman.services;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.*;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.List;

public class Fetcher {
    private String url;
    private String api_token;
    private List<String> fetchedData = new ArrayList<>();

    Fetcher(String url){
        this.url = url;
        this.api_token = System.getenv("API_TOKEN");
    }

    public void fetch() throws URISyntaxException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(url))
                .GET()
                .headers("Content-Type", "application/json;charset=UTF-8", "Authorization", "Bearer " + api_token)
                .build();

        client.sendAsync(request, BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(fetchedData::add)
                .join();
    }

    public List<String> getFetchedData() {
        return fetchedData;
    }
}
