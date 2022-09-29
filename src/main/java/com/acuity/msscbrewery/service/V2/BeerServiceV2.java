package com.acuity.msscbrewery.service.V2;

import com.acuity.msscbrewery.model.V2.BeerDtoV2;

import java.util.UUID;

/** Created by michael on 2022-09-26. */
public interface BeerServiceV2 {

  BeerDtoV2 getBeerById(UUID beerId);

  BeerDtoV2 saveBeer(BeerDtoV2 beer);

  void updateBeer(BeerDtoV2 beer);

  void deleteBeerById(UUID beerId);
}
