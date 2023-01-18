package pl.dolega.brewery.web.mapper;

import org.mapstruct.Mapper;
import pl.dolega.brewery.domain.Beer;
import pl.dolega.brewery.web.model.BeerDto;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

    BeerDto beerToBeerDto(Beer beer);

    Beer beerDtoToBeer(BeerDto dto);
}
