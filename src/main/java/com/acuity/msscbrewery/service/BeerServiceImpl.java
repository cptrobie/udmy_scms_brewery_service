package com.acuity.msscbrewery.service;

import com.acuity.msscbrewery.model.BeerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

/** Created by michael on 2022-09-26. */
@Service
public class BeerServiceImpl implements BeerService {
  @Override
  public BeerDto getBeerById(UUID beerId) {
    return BeerDto.builder()
        .id(beerId)
        .beerName("Galaxy Cat")
        .beerStyle("Pale Ale")
        .upc(123L)
        .build();
  }

  @Override
  public BeerDto saveBeer(BeerDto beerToSave) {
    return BeerDto.builder()
        .id(UUID.randomUUID())
        .beerName(beerToSave.getBeerName())
        .beerStyle(beerToSave.getBeerStyle())
        .upc(beerToSave.getUpc())
        .build();
  }
}
