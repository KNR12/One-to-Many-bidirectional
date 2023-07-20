package com.springboot.one.to.many.bidirectional.mapping.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Setter
@Getter
@RequiredArgsConstructor
@ToString
@Entity
@Table(name="product")
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="productName", length=32)
    private String productName;

    @Column(name="price")
    private Long price;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    @JsonIgnoreProperties("productList")
    private Customer customer;

}
