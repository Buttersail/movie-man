package dk.keadat21v2.movieman.services;

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
            fetcher.getFetchedData().forEach(System.out::println);
        } catch (URISyntaxException err){
            System.out.println(err);
        }
    }
}