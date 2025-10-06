package com.example.wscrud.controller;

import com.example.wscrud.model.WorkOrder;
import com.example.wscrud.dto.WorkOrderRequest;
import com.example.wscrud.dto.WorkOrderResponse;
import com.example.wscrud.service.WorkOrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workorders")
public class WorkOrderController {
    private final WorkOrderService service;

    public WorkOrderController(WorkOrderService service) {
        this.service = service;
    }

    @GetMapping
    public List<WorkOrder> getAll() {
        return service.findAll();
    }

    @PostMapping
    public List<WorkOrderResponse> create(@RequestBody WorkOrderRequest order) {
        System.out.println("Received WorkOrder: " + order.getWo());
        return service.findAll().stream()
                .map(o -> new WorkOrderResponse(
                        o.getId(),
                        o.getWorkOrderNumber(),
                        o.getStatus(),
                        o.getDescription()))
                .toList();
        // return service.save(order);
    }

    @PutMapping("/{id}")
    public WorkOrder update(@PathVariable Long id, @RequestBody WorkOrder order) {
        return service.update(id, order);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
