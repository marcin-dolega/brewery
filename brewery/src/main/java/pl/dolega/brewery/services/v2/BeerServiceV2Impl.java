package pl.dolega.brewery.services.v2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.dolega.brewery.web.model.BeerDto;
import pl.dolega.brewery.web.model.v2.BeerDtoV2;
import pl.dolega.brewery.web.model.v2.BeerStyle;

import java.util.UUID;

@Slf4j
@Service
public class BeerServiceV2Impl implements BeerServiceV2 {

    @Override
    public BeerDtoV2 getBeerById(UUID beerId) {
        return BeerDtoV2.builder()
                .id(UUID.randomUUID())
                .beerName("Galaxy Cat")
                .beerStyle(BeerStyle.ALE)
                .build();
    }

    @Override
    public BeerDtoV2 saveNewBeer(BeerDtoV2 beerDto) {
        return BeerDtoV2.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateBeer(UUID beerId, BeerDtoV2 beerDto) {

    }

    @Override
    public void deleteById(UUID beerId) {
        log.debug("Deleting a beer...");
    }
}
