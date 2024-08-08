package com.example.TestTask.controller;

import com.example.TestTask.entity.Computer;
import com.example.TestTask.service.ComputerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "/computer")
public class ComputerController {
    @Autowired
    private ComputerService computerService;

    @PostMapping
    public ResponseEntity<?> addComputer(@Valid @RequestBody Computer pc){
        return ResponseEntity.ok(computerService.addComputer(pc));
    }
    @GetMapping
    public ResponseEntity<List<Computer>> findAllComputers(){
        return ResponseEntity.ok(computerService.findAllComputers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Computer>> findComputerByID(@PathVariable UUID id){
        return ResponseEntity.ok(computerService.findComputerByID(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editComputer(@PathVariable UUID id, @Valid @RequestBody Computer newComputer){
        return ResponseEntity.ok(computerService.editComputer(id, newComputer));
    }
}
