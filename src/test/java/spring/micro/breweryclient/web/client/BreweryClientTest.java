package spring.micro.breweryclient.web.client;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring.micro.breweryclient.web.model.BeerDto;

import java.net.URI;
import java.util.UUID;

@SpringBootTest
public class BreweryClientTest {

    @Autowired
    BreweryClient breweryClient;

    @Test
    void getBeerById(){
        BeerDto beerDto = breweryClient.getBeerById(UUID.randomUUID());
        Assertions.assertNotNull(beerDto);
    }

    @Test
    void saveNewBeer(){
        BeerDto beerDto = BeerDto.builder().build();
        URI uri =
                breweryClient.saveNewBeer(beerDto);
        Assertions.assertNotNull(uri);
    }

    @Test
    void updateBeerById(){
        BeerDto beerDto = BeerDto.builder().build();
        breweryClient.updateBeerById(UUID.randomUUID(),beerDto);
    }

    @Test
    void deleteBeer(){
        breweryClient.deleteBeerById(UUID.randomUUID());
    }

}
