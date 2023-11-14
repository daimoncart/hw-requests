package com.hardware.requesting.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ComponentDto {
    private long componentId;
    private String category;
    private String model;
    private int quantity;
    private double price;
    private Long requestId;
}
