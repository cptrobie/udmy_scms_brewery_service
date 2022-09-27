package com.acuity.msscbrewery.controller;

import com.acuity.msscbrewery.model.BeerDto;
import com.acuity.msscbrewery.service.BeerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/** Created by michael on 2022-09-26. */
@RestController
@RequestMapping(value = "/v1/beer")
public class BeerController {

  private final BeerService beerService;

  public BeerController(BeerService beerService) {
    this.beerService = beerService;
  }

  @GetMapping(value = "/{beerId}")
  public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerId) {
    return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<BeerDto> createBeer(@RequestBody BeerDto newBeer) {

    BeerDto savedBeer = beerService.saveBeer(newBeer);

    HttpHeaders headers = new HttpHeaders();
    // todo add hostname to url
    headers.add("Location", "/v1/beer/" + savedBeer.getId().toString());

    return new ResponseEntity<>(headers, HttpStatus.CREATED);
  }
}
