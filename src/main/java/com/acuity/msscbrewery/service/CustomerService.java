package com.acuity.msscbrewery.service;

import com.acuity.msscbrewery.model.CustomerDto;

import java.util.UUID;

/** Created by michael on 2022-09-27. */
public interface CustomerService {

  CustomerDto getCustomerById(UUID customerId);

  CustomerDto saveCustomer(CustomerDto newCustomer);

  void updateCustomer(CustomerDto customer);

  void deleteCustomerById(UUID customerId);

}
