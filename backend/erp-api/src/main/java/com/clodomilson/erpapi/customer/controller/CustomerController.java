package com.clodomilson.erpapi.customer.controller;

import com.clodomilson.erpapi.customer.dto.CustomerRequest;
import com.clodomilson.erpapi.customer.dto.CustomerResponse;
import com.clodomilson.erpapi.customer.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService service;

    @PostMapping
    public CustomerResponse create(
            @RequestBody @Valid CustomerRequest request){

        return service.create(request);
    }

    @GetMapping
    public List<CustomerResponse> findAll(){
        return service.findAll();
    }
}