package com.example.wscrud.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "work_order")
public class WorkOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "work_order_number", nullable = false)
    private String workOrderNumber;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private String status; // เช่น "OPEN", "IN_PROGRESS", "DONE"
}
