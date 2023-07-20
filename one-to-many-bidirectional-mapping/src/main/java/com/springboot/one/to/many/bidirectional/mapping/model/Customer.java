package com.springboot.one.to.many.bidirectional.mapping.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="customer")
@Getter
@Setter
@RequiredArgsConstructor
@ToString
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="customerName", length=32, nullable=false)
    private String customerName;

    @Column(name="phoneNo", length=32, nullable = false)
    private String phoneNo;

    @Column(name="email", length=32, nullable=false)
    private String email;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private List<Products> productList;


}
