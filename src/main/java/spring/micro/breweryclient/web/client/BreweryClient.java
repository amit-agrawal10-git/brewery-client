package spring.micro.breweryclient.web.client;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import spring.micro.breweryclient.web.model.BeerDto;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(value = "micro.brewery", ignoreUnknownFields = false)
public class BreweryClient {

    public final String BEER_PATH_V1 = "/api/v1/beer/";
    private String apihost;
    private final RestTemplate restTemplate;

    public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public void setApihost(String apihost) {
        this.apihost = apihost;
    }

    public BeerDto getBeerById(UUID uuid){
        return restTemplate.getForObject(apihost+BEER_PATH_V1+uuid.toString(), BeerDto.class);
    }

    public URI saveNewBeer(BeerDto beerDto){
        return restTemplate.postForLocation(apihost+BEER_PATH_V1, beerDto);
    }

    public void deleteBeerById(UUID uuid){
        restTemplate.delete(apihost+BEER_PATH_V1+uuid.toString());
    }

    public void updateBeerById(UUID uuid, BeerDto beerDto){
        restTemplate.put(apihost+BEER_PATH_V1+uuid.toString(),beerDto);
    }
}
