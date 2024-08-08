package com.example.TestTask.controller;

import com.example.TestTask.entity.Monitor;
import com.example.TestTask.service.MonitorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "/monitor")
public class MonitorController {
    @Autowired
    private MonitorService monitorService;

    @PostMapping
    public ResponseEntity<?> addStuff(@Valid @RequestBody Monitor monitor){
        return ResponseEntity.ok(monitorService.addMonitor(monitor));
    }
    
    @GetMapping
    public ResponseEntity<List<Monitor>> showAllStuff(){
        return ResponseEntity.ok(monitorService.findAllMonitors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Monitor>> findMonitorByID(@PathVariable UUID id){
        return ResponseEntity.ok(monitorService.findMonitorByID(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editMonitor(@PathVariable UUID id, @Valid @RequestBody Monitor newMonitor){
        return ResponseEntity.ok(monitorService.editMonitor(id, newMonitor));
    }
}
