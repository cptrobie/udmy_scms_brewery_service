package com.acuity.msscbrewery.controller.V2;

import com.acuity.msscbrewery.model.V2.BeerDtoV2;
import com.acuity.msscbrewery.service.V2.BeerServiceV2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.UUID;

/** Created by michael on 2022-09-26. */
@RestController
@RequestMapping(value = "/v2/beer")
public class BeerControllerV2 {

  private final BeerServiceV2 beerService;

  public BeerControllerV2(BeerServiceV2 beerService) {
    this.beerService = beerService;
  }

  @GetMapping(value = "/{beerId}")
  public ResponseEntity<BeerDtoV2> getBeer(@PathVariable("beerId") UUID beerId) {
    return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<Void> createBeer(@RequestBody BeerDtoV2 newBeer) {
    BeerDtoV2 savedBeer = beerService.saveBeer(newBeer);

    HttpHeaders headers = new HttpHeaders();
    // todo add hostname to url
    headers.setLocation(URI.create("/v1/beer/" + savedBeer.getId().toString()));

    return new ResponseEntity<>(headers, HttpStatus.CREATED);
  }

  @PutMapping(value = "/{beerId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void updateBeer(@PathVariable("beerId") UUID beerId, @RequestBody BeerDtoV2 beer) {
    beer.setId(beerId); // ensure that both values match
    beerService.updateBeer(beer);
  }

  @DeleteMapping(value = "/{beerId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteBeer(@PathVariable("beerId") UUID beerId) {
    beerService.deleteBeerById(beerId);
  }
}
