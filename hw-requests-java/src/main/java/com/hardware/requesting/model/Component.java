package com.hardware.requesting.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "component")
public class Component {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long componentId;

    private String category;
    private String model;
    private int quantity;
    private Long requestId;
    private double price;

    public Component(final String category, final String model, final int quantity, final double price) {
        this.category = category;
        this.model = model;
        this.quantity = quantity;
        this.price = price;
    }
}
