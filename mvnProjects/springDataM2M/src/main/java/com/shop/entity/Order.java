package com.shop.entity;

import jakarta.persistence.*;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter //Lombok
@Setter //Lombok
@Entity // SpringData
@Accessors(chain = true) // Lombok
@Table(name = "basket") // SpringData
public class Order {

    @Id // SpringData
    @GeneratedValue(strategy = GenerationType.IDENTITY) // SpringData
    private Long id;

    private String userName;

    private Double cost;

    private String description;

    @ManyToMany
    @JoinTable(name = "purchase",
            joinColumns = @JoinColumn(name = "basket_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"))
    private List<Product> products;

}
