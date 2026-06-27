package com.clodomilson.erpapi.customer.service;

import com.clodomilson.erpapi.customer.dto.CustomerRequest;
import com.clodomilson.erpapi.customer.dto.CustomerResponse;
import com.clodomilson.erpapi.customer.entity.Customer;
import com.clodomilson.erpapi.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;

    public CustomerResponse create(CustomerRequest request){

        Customer customer = Customer.builder()
                .name(request.name())
                .email(request.email())
                .phone(request.phone())
                .build();

        Customer saved = repository.save(customer);

        return new CustomerResponse(
                saved.getId(),
                saved.getName(),
                saved.getEmail(),
                saved.getPhone()
        );
    }

    public List<CustomerResponse> findAll(){

        return repository.findAll()
                .stream()
                .map(customer ->
                        new CustomerResponse(
                                customer.getId(),
                                customer.getName(),
                                customer.getEmail(),
                                customer.getPhone()
                        )
                )
                .toList();
    }
}