package com.springboot.one.to.many.bidirectional.mapping.respository;

import com.springboot.one.to.many.bidirectional.mapping.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface CustomerRespository extends JpaRepository<Customer,Long> {

    Optional<Customer> findByEmail(String email);
}
