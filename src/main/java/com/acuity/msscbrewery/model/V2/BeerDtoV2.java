package com.acuity.msscbrewery.model.V2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/** Created by michael on 2022-09-26. */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class BeerDtoV2 {

  private UUID id;
  private String beerName;
  private BeerStyleEnum beerStyle;
  private Long upc;
}
