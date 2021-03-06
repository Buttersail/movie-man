package dk.keadat21v2.movieman.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dk.keadat21v2.movieman.error.Client4xxException;
import org.springframework.http.HttpStatus;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.*;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Map;

public class Fetcher {
    private String url;
    private String api_token;
    private String json;
    private ObjectMapper mapper = new ObjectMapper();

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
                .thenApply((response) -> {
                    if (response.statusCode() != 200){
                    throw new Client4xxException(response.body(), HttpStatus.valueOf(response.statusCode()));
                    }
                    return response.body();
                }).thenAccept((data) -> json = data)
                .join();
        }

    public Map<String, Object> getFetchedMap() throws JsonProcessingException{
        return mapper.readValue(json, Map.class);
    }

    public String getJson(){
        return json;
    }
}
