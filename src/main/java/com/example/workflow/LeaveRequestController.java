package com.example.workflow;

import org.springframework.web.bind.annotation.RestController;
import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Map;

@RestController
@RequestMapping("/api/leave")
public class LeaveRequestController {


    @Autowired
    private RuntimeService runtimeService;

    @PostMapping
    public String startLeaveProcess(@RequestBody LeaveRequest request) {
        runtimeService.startProcessInstanceByKey(
            "leave_request", // Process ID from BPMN
            Map.of(
                "employeeName", request.getEmployeeName(),
                "days", request.getDays()
            )
        );
        return "Leave request process started!";
    }

    
}
