package com.springboot.one.to.many.bidirectional.mapping.services;

import com.springboot.one.to.many.bidirectional.mapping.model.Customer;
import com.springboot.one.to.many.bidirectional.mapping.model.Products;
import com.springboot.one.to.many.bidirectional.mapping.respository.CustomerRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServicesImplementation implements CustomerServices {

    @Autowired
    private CustomerRespository customerRespository;

    @Override
    public List<Customer> findAll() {
        return customerRespository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        Optional<Customer> customerResult = customerRespository.findById(id);
        Customer customer;
        if (customerResult.isPresent()) {
            customer = customerResult.get();
        } else {
            throw new RuntimeException("Customer id not found-" +id);
        }
        return customer;
    }

    @Override
    public Optional<Customer> findByEmail(String email) {
        return customerRespository.findByEmail(email);
    }

    @Override
    public Customer save(Customer customer) {
        List<Products> products = customer.getProductList();

        List<Products>  prodList = new ArrayList<Products>();

        for (Products product1 : products){

            product1.setCustomer(customer);

            prodList.add(product1);
        }
        customer.setProductList(prodList);
        return customerRespository.save(customer);
    }

    @Override
    public void deleteById(Long id) {
        customerRespository.deleteById(id);


    }
}
