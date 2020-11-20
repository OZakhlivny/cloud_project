package com.geekbrains.order.service.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToMany(mappedBy = "order")
    @Cascade({org.hibernate.annotations.CascadeType.ALL})
    private List<OrderItem> items;

    @Column(name = "price")
    private int price;

    @Column(name = "address")
    private String address;

    public Order(List<OrderItem>items, int price) {
        this.items = items;
        this.price = price;
        items.forEach(oi -> oi.setOrder(this));
    }
}
