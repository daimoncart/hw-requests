package com.hardware.requesting.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "request")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;
    private String reasoning;
    private String status;

    @Column(nullable = false, updatable = false)
    private double total;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private ZonedDateTime createdDate;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "requestId")
    private List<Component> components;

    public Request(String reasoning, String status, double total, List<Component> components) {
        this.reasoning = reasoning;
        this.status = status;
        this.total = total;
        this.components = components;
    }
}
