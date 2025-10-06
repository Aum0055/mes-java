package com.example.wscrud.controller;

import com.example.wscrud.model.WorkOrder;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class DashboardController {

    @MessageMapping("/update")
    @SendTo("/topic/dashboard")
    public WorkOrder broadcastUpdate(WorkOrder order) {
        // ทุกครั้งที่มี message เข้ามา -> broadcast ไป /topic/dashboard
        return order;
    }
}
