package com.hardware.requesting.model;

import lombok.Data;

import java.time.ZonedDateTime;
import java.util.List;

@Data
public class RequestDto {
    private long id;
    private String reasoning;
    private String status;
    private double total;
    private ZonedDateTime createdDate;
    private List<ComponentDto> componentBlock;
}
