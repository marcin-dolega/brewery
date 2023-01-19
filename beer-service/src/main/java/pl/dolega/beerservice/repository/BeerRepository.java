package pl.dolega.beerservice.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import pl.dolega.beerservice.domain.Beer;
import pl.dolega.beerservice.web.model.BeerDto;

import java.util.UUID;

public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID>, CrudRepository<Beer, UUID> {

//    void save(Beer beer);
//    int count();

}
