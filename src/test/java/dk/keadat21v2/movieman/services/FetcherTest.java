package dk.keadat21v2.movieman.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.net.URISyntaxException;

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
            System.out.println(fetcher.getFetchedMap().toString());
        } catch (URISyntaxException|JsonProcessingException err){
            System.out.println(err);
        }
    }
}