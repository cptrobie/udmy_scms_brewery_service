package com.acuity.msscbrewery.model;

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
public class BeerDto {

  private UUID id;
  private String beerName;
  private String beerStyle;
  private Long upc;
}
