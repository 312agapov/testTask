package com.example.TestTask.service;

import com.example.TestTask.entity.Notebook;
import com.example.TestTask.entity.Monitor;
import com.example.TestTask.entity.Notebook;
import com.example.TestTask.repository.MonitorRepository;
import com.example.TestTask.repository.NotebookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class NotebookService {
    @Autowired
    private NotebookRepository notebookRepository;

    public Notebook addNotebook(Notebook notebook){
        return notebookRepository.save(notebook);

    }

    public List<Notebook> findAllNotebooks(){
        return notebookRepository.findAll();
    }

    public Optional<Notebook> findNotebookByID(UUID id){
        Optional<Notebook> optionalNotebook = notebookRepository.findById(id);
        if (optionalNotebook.isPresent()) {
            return notebookRepository.findById(id);
        } else {
            throw new IllegalArgumentException("Notebook with ID " + id + " not found");
        }
    }

    public Notebook editNotebook(UUID id, Notebook newNotebook){
        Optional<Notebook> optionalNotebook = notebookRepository.findById(id);

        if (optionalNotebook.isPresent()){
            Notebook existingNotebook = optionalNotebook.get();
            existingNotebook.setMaker(newNotebook.getMaker());
            existingNotebook.setSerialNumber((newNotebook.getSerialNumber()));
            existingNotebook.setPrice(newNotebook.getPrice());
            existingNotebook.setCount(newNotebook.getCount());
            existingNotebook.setDiagonal(newNotebook.getDiagonal());
            return notebookRepository.save(existingNotebook);
        } else {
            throw new IllegalArgumentException("Notebook with ID " + id + " not found");
        }
    }
}
