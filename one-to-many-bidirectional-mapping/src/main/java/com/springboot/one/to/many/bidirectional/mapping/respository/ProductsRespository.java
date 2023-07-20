package com.springboot.one.to.many.bidirectional.mapping.respository;

import com.springboot.one.to.many.bidirectional.mapping.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRespository extends JpaRepository<Products,Long> {


}
