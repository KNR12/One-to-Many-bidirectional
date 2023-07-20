package com.springboot.one.to.many.bidirectional.mapping.restcontroller;

import com.springboot.one.to.many.bidirectional.mapping.model.Products;
import com.springboot.one.to.many.bidirectional.mapping.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/ProductApi")
public class ProductRestController {

    @Autowired
    private ProductServices productServices;


    //allcustomer return all customer
    @GetMapping("/allproducts")
    public List<Products> findAll(){
        return productServices.getProducts();
    }
    //
    @GetMapping("/product")
    public Products getProduct(@RequestParam Long id){
        Products products=productServices.findById(id);
        return products;
    }

}
