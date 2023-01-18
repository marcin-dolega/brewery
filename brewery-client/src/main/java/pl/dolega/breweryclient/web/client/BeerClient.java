package pl.dolega.breweryclient.web.client;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.dolega.breweryclient.web.model.BeerDto;

import java.net.URI;
import java.util.UUID;

//todo configuration properties
//@ConfigurationProperties(prefix = "pl.brewery", ignoreUnknownFields = false)
@Component
public class BeerClient {

    private final String BEER_PATH_V1 = "/api/v1/beer";
    private String apiHost = "http://localhost:8080";

    private final RestTemplate restTemplate;

    public BeerClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public BeerDto getBeerById(UUID uuid) {
        return restTemplate.getForObject(apiHost + BEER_PATH_V1 + "/" + uuid.toString(), BeerDto.class);
    }

    public URI saveNewBeer(BeerDto dto) {
        return restTemplate.postForLocation(apiHost + BEER_PATH_V1, dto);
    }

    public void updateBeer(UUID uuid, BeerDto dto) {
        restTemplate.put(apiHost + BEER_PATH_V1 + "/" + uuid.toString(), dto);
    }

    public void deleteBeer(UUID uuid) {
        restTemplate.delete(apiHost + BEER_PATH_V1 + "/" + uuid.toString());
    }

}
