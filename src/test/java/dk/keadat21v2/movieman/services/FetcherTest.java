package dk.keadat21v2.movieman.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class FetcherTest {

    static Fetcher fetcher;

    //@BeforeAll
    static void setup(){
        fetcher = new Fetcher("https://api.themoviedb.org/3/movie/503");
    }

    //@Test
    void fetch() {
        try {
            fetcher.fetch();
            System.out.println(fetcher.getFetchedData().toString());
        } catch (URISyntaxException|JsonProcessingException err){
            System.out.println(err);
        }
    }
}