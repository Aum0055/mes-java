package com.example.wscrud.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WorkOrderResponse {
    private Long wo_id;
    private String wo;
    private String status;
    private String desc;
}
