package spring.micro.breweryclient.service;

import spring.micro.breweryclient.web.model.BeerDto;

import java.util.UUID;

public interface BeerService {
    public BeerDto getBeerById(UUID beerId);
    public void deleteBeerById(UUID beerId);
    public BeerDto saveBeer(BeerDto beerDto);
    public void updateBeer(UUID uuid,BeerDto beerDto);
}
