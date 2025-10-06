// WorkOrderService.java
package com.example.wscrud.service;

import com.example.wscrud.model.WorkOrder;
import com.example.wscrud.repository.WorkOrderRepository;
import com.example.wscrud.dto.WorkOrderServiceDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkOrderService implements WorkOrderServiceDTO {

    private final WorkOrderRepository repository;

    public WorkOrderService(WorkOrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<WorkOrder> findAll() {
        return repository.findAll();
    }

    @Override
    public WorkOrder save(WorkOrder order) {
        return repository.save(order);
    }

    @Override
    public WorkOrder update(Long id, WorkOrder newOrder) {
        return repository.findById(id).map(order -> {
            order.setWorkOrderNumber(newOrder.getWorkOrderNumber());
            order.setDescription(newOrder.getDescription());
            order.setStatus(newOrder.getStatus());
            return repository.save(order);
        }).orElseThrow(() -> new RuntimeException("WorkOrder not found"));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
