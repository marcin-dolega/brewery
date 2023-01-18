package pl.dolega.beerservice.web.mapper;

import org.mapstruct.Mapper;
import pl.dolega.beerservice.domain.Beer;
import pl.dolega.beerservice.web.model.BeerDto;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

    BeerDto beerToBeerDto(Beer beer);

    Beer beerDtoToBeer(BeerDto dto);
}
