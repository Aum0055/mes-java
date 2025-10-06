// WorkOrderServiceDTO.java
package com.example.wscrud.dto;

import com.example.wscrud.model.WorkOrder;
import java.util.List;

public interface WorkOrderServiceDTO {
    List<WorkOrder> findAll();
    WorkOrder save(WorkOrder order);
    WorkOrder update(Long id, WorkOrder newOrder);
    void delete(Long id);
}
