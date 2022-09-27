package com.acuity.msscbrewery.controller;

import com.acuity.msscbrewery.model.CustomerDto;
import com.acuity.msscbrewery.service.CustomerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.UUID;

/** Created by michael on 2022-09-27. */
@RestController
@RequestMapping(value = "/v1/customer")
public class CustomerController {

  CustomerService customerService;

  public CustomerController(CustomerService customerService) {
    this.customerService = customerService;
  }

  @GetMapping({"/{customerId}"})
  public ResponseEntity<CustomerDto> getCustomer(@PathVariable("customerId") UUID customerId) {
    return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<Void> createCustomer(@RequestBody CustomerDto newCustomer) {
    CustomerDto savedCustomer = customerService.saveCustomer(newCustomer);

    HttpHeaders headers = new HttpHeaders();
    headers.setLocation(URI.create("/v1/customer/" + savedCustomer.getId().toString()));

    return new ResponseEntity<>(headers, HttpStatus.CREATED);
  }

  @PutMapping({"/{customerId}"})
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void updateCustomer(@PathVariable("customerId") UUID customerId, @RequestBody CustomerDto customer) {
    customer.setId(customerId);// ensure that both values match
    customerService.updateCustomer(customer);
  }

  @DeleteMapping({"/{customerId}"})
  @ResponseStatus(HttpStatus.NO_CONTENT)
  void deleteCustomer(@PathVariable("customerId") UUID customerId) {
    customerService.deleteCustomerById(customerId);
  }
}
