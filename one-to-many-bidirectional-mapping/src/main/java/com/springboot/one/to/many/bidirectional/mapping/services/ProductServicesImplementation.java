package com.springboot.one.to.many.bidirectional.mapping.services;
import com.springboot.one.to.many.bidirectional.mapping.model.Products;
import com.springboot.one.to.many.bidirectional.mapping.respository.ProductsRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServicesImplementation implements ProductServices {




    @Autowired
    private ProductsRespository productsRespository;

    @Override
    public List<Products> getProducts() {
        return productsRespository.findAll();
    }

    @Override
    public Products findById(Long id) {
        Optional<Products> productResult = productsRespository.findById(id);
        Products products;
        if (productResult.isPresent()) {
           products = productResult.get();
        } else {
            throw new RuntimeException("Product id not found-" + id);
        }
        return products;
    }

    }

