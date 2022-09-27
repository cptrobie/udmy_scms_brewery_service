package com.acuity.msscbrewery.controller;

import com.acuity.msscbrewery.model.BeerDto;
import com.acuity.msscbrewery.service.BeerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
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
  public ResponseEntity<Void> createBeer(@RequestBody BeerDto newBeer) {
    BeerDto savedBeer = beerService.saveBeer(newBeer);

    HttpHeaders headers = new HttpHeaders();
    // todo add hostname to url
    headers.setLocation(URI.create("/v1/beer/" + savedBeer.getId().toString()));

    return new ResponseEntity<>(headers, HttpStatus.CREATED);
  }

  @PutMapping(value = "/{beerId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void updateBeer(@PathVariable("beerId") UUID beerId, @RequestBody BeerDto beer) {
    beer.setId(beerId); // ensure that both values match
    beerService.updateBeer(beer);
  }

  @DeleteMapping(value = "/{beerId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteBeer(@PathVariable("beerId") UUID beerId) {
    beerService.deleteBeerById(beerId);
  }
}
