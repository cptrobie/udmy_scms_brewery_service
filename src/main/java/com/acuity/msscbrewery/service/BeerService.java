package com.acuity.msscbrewery.service;

import com.acuity.msscbrewery.model.BeerDto;

import java.util.UUID;

/** Created by michael on 2022-09-26. */
public interface BeerService {

  BeerDto getBeerById(UUID beerId);

  BeerDto saveBeer(BeerDto beer);

  void updateBeer(BeerDto beer);

  void deleteBeerById(UUID beerId);
}
