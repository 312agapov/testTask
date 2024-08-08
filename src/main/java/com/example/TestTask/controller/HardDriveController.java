package com.example.TestTask.controller;

import com.example.TestTask.entity.HardDrive;
import com.example.TestTask.service.HardDriveService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "/harddrive")
public class HardDriveController {
    @Autowired
    private HardDriveService hardDriveService;

    @PostMapping
    public ResponseEntity<?> addHardDrive(@Valid @RequestBody HardDrive hd){
        return ResponseEntity.ok(hardDriveService.addHardDrive(hd));
    }

    @GetMapping
    public ResponseEntity<List<HardDrive>> findAllHArdDrives(){
        return ResponseEntity.ok(hardDriveService.findAllHardDrives());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<HardDrive>> findHardDriveByID(@PathVariable UUID id){
        return ResponseEntity.ok(hardDriveService.findHardDriveByID(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editHardDrive(@PathVariable UUID id, @Valid @RequestBody HardDrive newHardDrive){
        return ResponseEntity.ok(hardDriveService.editHardDrive(id, newHardDrive));
    }
}
