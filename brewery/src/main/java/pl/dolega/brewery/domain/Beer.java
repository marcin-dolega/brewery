package pl.dolega.brewery.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.dolega.brewery.web.model.v2.BeerStyle;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Beer {

    private UUID id;
    private String beerName;
    private BeerStyle beerStyle;
    private Long upc;

}
