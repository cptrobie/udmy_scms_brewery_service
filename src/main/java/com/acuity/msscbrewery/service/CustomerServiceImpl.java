package com.acuity.msscbrewery.service;

import com.acuity.msscbrewery.model.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

/** Created by michael on 2022-09-27. */
@Service
public class CustomerServiceImpl implements CustomerService {

  @Override
  public CustomerDto getCustomerById(UUID customerId) {
    return CustomerDto.builder().id(customerId).name("Joe Black").build();
  }

  @Override
  public CustomerDto saveCustomer(CustomerDto newCustomer) {
    return null;
  }

  @Override
  public void updateCustomer(CustomerDto customer) {

  }

  @Override
  public void deleteCustomerById(UUID customerId) {

  }
}
