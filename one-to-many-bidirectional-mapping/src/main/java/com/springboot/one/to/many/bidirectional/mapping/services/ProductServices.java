package com.springboot.one.to.many.bidirectional.mapping.services;

import com.springboot.one.to.many.bidirectional.mapping.model.Products;
import java.util.List;

public interface ProductServices {

    public List<Products> getProducts();

    public Products findById(Long id);





}
