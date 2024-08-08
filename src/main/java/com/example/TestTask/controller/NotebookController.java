package com.example.TestTask.controller;

import com.example.TestTask.entity.Notebook;
import com.example.TestTask.service.NotebookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "/notebook")
public class NotebookController {
    @Autowired
    private NotebookService notebookService;

    @PostMapping
    public ResponseEntity<?> addStuff(@Valid @RequestBody Notebook notebook){
        return ResponseEntity.ok(notebookService.addNotebook(notebook));
    }

    @GetMapping
    public ResponseEntity<List<Notebook>> showAllStuff(){
        return ResponseEntity.ok(notebookService.findAllNotebooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Notebook>> findNotebookByID(@PathVariable UUID id){
        return ResponseEntity.ok(notebookService.findNotebookByID(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editNotebook(@PathVariable UUID id, @Valid @RequestBody Notebook newNotebook){
        return ResponseEntity.ok(notebookService.editNotebook(id, newNotebook));
    }
}
