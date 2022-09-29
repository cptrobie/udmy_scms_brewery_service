package com.acuity.msscbrewery.service.V2;

import com.acuity.msscbrewery.model.V2.BeerDtoV2;
import com.acuity.msscbrewery.model.V2.BeerStyleEnum;
import org.springframework.stereotype.Service;

import java.util.UUID;

/** Created by michael on 2022-09-26. */
@Service
public class BeerServiceImplV2 implements BeerServiceV2 {
  @Override
  public BeerDtoV2 getBeerById(UUID beerId) {
    return BeerDtoV2.builder()
        .id(beerId)
        .beerName("Galaxy Cat")
        .beerStyle(BeerStyleEnum.LAGER)
        .upc(123L)
        .build();
  }

  @Override
  public BeerDtoV2 saveBeer(BeerDtoV2 beerToSave) {
    return BeerDtoV2.builder()
        .id(UUID.randomUUID())
        .beerName(beerToSave.getBeerName())
        .beerStyle(beerToSave.getBeerStyle())
        .upc(beerToSave.getUpc())
        .build();
  }

  @Override
  public void updateBeer(BeerDtoV2 beer) {
  }

  @Override
  public void deleteBeerById(UUID beerId) {
  }
}
