package com.springboot.one.to.many.bidirectional.mapping.services;

import com.springboot.one.to.many.bidirectional.mapping.model.Customer;
import java.util.List;
import java.util.Optional;

public interface CustomerServices {

    public List<Customer> findAll();

    public Customer findById(Long id);

    Optional<Customer> findByEmail(String email);

    public Customer save(Customer customer);

    public void deleteById(Long id);
}
