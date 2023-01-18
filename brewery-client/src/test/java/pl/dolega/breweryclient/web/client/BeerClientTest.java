package pl.dolega.breweryclient.web.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.dolega.breweryclient.web.model.BeerDto;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BeerClientTest {

    @Autowired
    BeerClient client;

    @Test
    void getBeerByIdTest() {
        BeerDto dto = client.getBeerById(UUID.randomUUID());
        assertNotNull(dto);
    }

    @Test
    void saveNewBeerTest() {
        BeerDto dto = BeerDto.builder().beerName("New Beer").build();
        URI uri = client.saveNewBeer(dto);
        assertNotNull(uri);
        System.out.println(uri.toString());
    }

    @Test
    void updateBeerTest() {
        BeerDto dto = BeerDto.builder().beerName("New Beer").build();
        client.updateBeer(UUID.randomUUID(), dto);
    }

    @Test
    void deleteBeerTest() {
        client.deleteBeer(UUID.randomUUID());
    }
}